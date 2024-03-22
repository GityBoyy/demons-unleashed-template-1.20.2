package net.chubby.dm.entity.creatures.model;

import net.chubby.dm.entity.animations.BlazeLegEntityAnimation;
import net.chubby.dm.entity.animations.ShadowLurkerEntityAnimations;
import net.chubby.dm.entity.creatures.EntityBlazeLeg;
import net.chubby.dm.entity.creatures.EntityShadowLurker;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BlazeLegModel<T extends EntityBlazeLeg> extends SinglePartEntityModel<T> {
	private final ModelPart BlazeLeg;
	private final ModelPart head;
	public BlazeLegModel(ModelPart root) {
		this.BlazeLeg = root.getChild("BlazeLeg");
		this.head = root.getChild("BlazeLeg").getChild("Head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData BlazeLeg = modelPartData.addChild("BlazeLeg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Head = BlazeLeg.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -24.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(-0.5F))
		.uv(0, 16).cuboid(-4.0F, -22.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(-0.5F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData Body = BlazeLeg.addChild("Body", ModelPartBuilder.create().uv(32, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -38.0F, 0.0F));

		ModelPartData RightArm = BlazeLeg.addChild("RightArm", ModelPartBuilder.create().uv(56, 0).cuboid(-3.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -36.0F, 0.0F));

		ModelPartData LeftArm = BlazeLeg.addChild("LeftArm", ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(5.0F, -36.0F, 0.0F));

		ModelPartData RightLeg = BlazeLeg.addChild("RightLeg", ModelPartBuilder.create().uv(56, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -26.0F, 0.0F));

		ModelPartData LeftLeg = BlazeLeg.addChild("LeftLeg", ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, -26.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 32);
	}

	@Override
	public void setAngles(EntityBlazeLeg entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(BlazeLegEntityAnimation.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, BlazeLegEntityAnimation.IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, BlazeLegEntityAnimation.SHOOT, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		BlazeLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}


	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public ModelPart getPart() {
		return BlazeLeg;
	}



}