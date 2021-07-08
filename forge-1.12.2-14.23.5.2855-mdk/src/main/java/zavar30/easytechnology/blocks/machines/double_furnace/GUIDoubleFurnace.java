package zavar30.easytechnology.blocks.machines.double_furnace;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zavar30.easytechnology.ETConstants;

@SideOnly(Side.CLIENT)
public class GUIDoubleFurnace extends GuiContainer
{
    private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation(ETConstants.MODID + ":textures/gui/double_furnace.png");
    private final InventoryPlayer playerInventory;
    private final DoubleFurnaceTileEntity tileFurnace;
	private ITextComponent tct = new TextComponentTranslation("double_furnace.use.text", "dank");
	private ITextComponent send = new TextComponentTranslation("double_furnace.tutorial.text", "dank");

    public GUIDoubleFurnace(InventoryPlayer playerInv, DoubleFurnaceTileEntity furnaceInv)
    {
        super(new ContainerDoubleFurnace(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.tileFurnace = furnaceInv;
    }
    
    @Override
    public void initGui() {
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        
        this.buttonList.add(new GuiButton(0, i + 99, j + 61, 70, 20, tct.getFormattedText()));
    	super.initGui();
    }
    
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	if(button.id == 0)
    	{
    		if(Minecraft.getMinecraft().world.isRemote) {

				Minecraft.getMinecraft().player.sendMessage(send);
    		}
    	}
    	super.actionPerformed(button);
    }
  
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
    
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFurnace.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(FURNACE_GUI_TEXTURES);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        
        if (DoubleFurnaceTileEntity.isBurning(this.tileFurnace))
        {
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }
        
        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(i + 79, j + 34, 176, 14, l + 1, 16);
    }

    private int getCookProgressScaled(int pixels)
    {
        int i = this.tileFurnace.getField(2);
        int j = this.tileFurnace.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tileFurnace.getField(1);
        if (i <= 0)
        {
            i = 200;
        }
        if(this.tileFurnace.getField(0) <= 0)
        {
        	return 0;
        }
        else
        return this.tileFurnace.getField(0) * pixels / i;
    }
}