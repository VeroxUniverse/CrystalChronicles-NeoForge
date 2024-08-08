package net.veroxuniverse.crystal_chronicles.entity.custom;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.Animation;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.sblforked.api.SmartBrainOwner;
import mod.azure.azurelib.sblforked.api.core.BrainActivityGroup;
import mod.azure.azurelib.sblforked.api.core.SmartBrainProvider;
import mod.azure.azurelib.sblforked.api.core.behaviour.FirstApplicableBehaviour;
import mod.azure.azurelib.sblforked.api.core.behaviour.OneRandomBehaviour;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.attack.AnimatableMeleeAttack;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.look.LookAtTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.misc.Idle;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.move.MoveToWalkTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.move.StrafeTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.path.SetRandomWalkTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.path.SetWalkTargetToAttackTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.InvalidateAttackTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.SetPlayerLookTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.SetRandomLookTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.TargetOrRetaliate;
import mod.azure.azurelib.sblforked.api.core.sensor.ExtendedSensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.HurtBySensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.LookAtTargetSink;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.veroxuniverse.crystal_chronicles.entity.AnimatedMonsterEntity;

import java.util.List;

public class CrystalDrakeEntity extends AnimatedMonsterEntity implements SmartBrainOwner<CrystalDrakeEntity> {
    public CrystalDrakeEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder attributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 90.0D)
                .add(Attributes.ATTACK_DAMAGE, 12.0D)
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.4D);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar
                .add(new AnimationController<>(this, "livingController", 0, state -> {
                    if (state.isMoving() && !swinging)  {
                        state.setAnimation(RawAnimation.begin().thenLoop("walk"));
                        return PlayState.CONTINUE;
                    }
                    state.setAnimation(RawAnimation.begin().thenLoop("idle"));
                    return PlayState.CONTINUE;
                }))
                .add(new AnimationController<>(this, "attackController", 0, event -> {
                    swinging = false;
                    return PlayState.STOP;
                }).triggerableAnim("attack", RawAnimation.begin().then("attack", Animation.LoopType.PLAY_ONCE))
                        .triggerableAnim("glide", RawAnimation.begin().then("glide", Animation.LoopType.PLAY_ONCE)));
    }

    @Override
    protected Brain.Provider<?> brainProvider() {
        return new SmartBrainProvider<>(this);
    }

    @Override
    protected void customServerAiStep() {
        tickBrain(this);
    }

    @Override
    public List<ExtendedSensor<CrystalDrakeEntity>> getSensors() {
        return ObjectArrayList.of(
                new NearbyLivingEntitySensor<CrystalDrakeEntity>().setPredicate(
                        (target, entity) -> target.isAlive() && entity.hasLineOfSight(target) && !(target instanceof AnimatedMonsterEntity)),
                new HurtBySensor<>()
        );
    }

    @Override
    public BrainActivityGroup<CrystalDrakeEntity> getCoreTasks() {
        return BrainActivityGroup.coreTasks(
                new LookAtTarget<>(),
                new LookAtTargetSink(35, 120),
                new StrafeTarget<>()
                        .speedMod(0.75F)
                        .whenStarting(entity -> {
                            this.triggerAnim("attackController", "glide");
                        }),
                new MoveToWalkTarget<>()
        );
    }

    @Override
    public BrainActivityGroup<CrystalDrakeEntity> getIdleTasks() {
        return BrainActivityGroup.idleTasks(new FirstApplicableBehaviour<CrystalDrakeEntity>(
                        new TargetOrRetaliate<>().alertAlliesWhen((mob, entity) -> this.isAggressive()),
                        new SetPlayerLookTarget<>().stopIf(target -> !target.isAlive() || target instanceof Player player && player.isCreative()),
                        new SetRandomLookTarget<>()),
                new OneRandomBehaviour<>(new SetRandomWalkTarget<>().setRadius(20).speedModifier(0.8f),
                        new Idle<>().runFor(entity -> entity.getRandom().nextInt(300, 600))));
    }

    @Override
    public BrainActivityGroup<CrystalDrakeEntity> getFightTasks() {
        return BrainActivityGroup.fightTasks(
                new InvalidateAttackTarget<>(),
                new SetWalkTargetToAttackTarget<>()
                        .whenStarting(entity -> {
                    this.triggerAnim("attackController", "glide");
                        }),
                new AnimatableMeleeAttack<>(0)
                        .whenStarting(entity -> {
                            this.triggerAnim("attackController", "attack");
                        })
        );
    }

    @Override
    protected void registerGoals() {
    }

    @Override
    public boolean isBaby() {
        return false;
    }



}
