package pieselki.bright_utilities.blocks;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import pieselki.bright_utilities.BrightUtilities;

public class PowerProxyScreen extends ContainerScreen<PowerProxyContainer> {
  private ResourceLocation GUI = new ResourceLocation(BrightUtilities.MODID, "textures/gui/power_proxy.png");

  public PowerProxyScreen(PowerProxyContainer container, PlayerInventory inv, ITextComponent name) {
    super(container, inv, name);
  }

  @Override
  public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
    this.renderBackground(matrixStack);
    super.render(matrixStack, mouseX, mouseY, partialTicks);
    this.renderTooltip(matrixStack, mouseX, mouseY);
  }

  @Override
  protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) {
    Minecraft instance = Minecraft.getInstance();
    drawString(matrixStack, instance.font, "Transfer rate: 80 RF/T", 10, 10, 0xffffff);
  }

  @Override
  protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
    RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.minecraft.getTextureManager().bind(GUI);
    int relX = (this.width - this.imageWidth) / 2;
    int relY = (this.height - this.imageHeight) / 2;
    this.blit(matrixStack, relX, relY, 0, 0, this.imageWidth, this.imageHeight);
  }
}