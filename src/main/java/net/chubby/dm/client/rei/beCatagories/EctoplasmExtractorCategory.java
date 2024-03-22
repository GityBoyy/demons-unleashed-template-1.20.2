package net.chubby.dm.client.rei.beCatagories;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.init.ModBlocks;
import net.minecraft.client.util.math.Rect2i;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class EctoplasmExtractorCategory implements DisplayCategory<BasicDisplay>
{
    public static final Identifier TEXTURE = new Identifier(DemonsUnleased.MOD_ID,
            "textures/gui/ectoplasm_screen_gui");
    public static final CategoryIdentifier<EctoplasmExtractorDisplay> ECTOPLASM_EXTRACTOR =
            CategoryIdentifier.of(DemonsUnleased.MOD_ID,"ectoplasm_extractor");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return ECTOPLASM_EXTRACTOR;
    }

    @Override
    public Text getTitle() {
        return Text.literal("Ectoplasm Extractor");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.ECTOPLASM_EXTRACTOR.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX()-87, bounds.getCenterY()-35);
        List<Widget> widgets = new LinkedList<>();

        widgets.add(Widgets.createTexturedWidget(TEXTURE,
                new Rectangle(startPoint.x, startPoint.y, 175, 82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 31, startPoint.y + 17))
                .entries(display.getInputEntries().get(0)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 95, startPoint.y + 17))
                .entries(display.getInputEntries().get(0)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 64, startPoint.y + 44))
                .markOutput().entries(display.getOutputEntries().get(0)));

        widgets.add(Widgets.createDrawableWidget((graphics, mouseX, mouseY, delta) -> {
            Rect2i area = new Rect2i(startPoint.x + 156, startPoint.y + 11, 8, 64);
            final int height = area.getHeight();
            int stored = (int)Math.ceil(height * (((EctoplasmExtractorDisplay) display).getTotalEnergyAmount() / 64000f));

            graphics.fillGradient(area.getX(), area.getY() + (height - stored),
                    area.getX() + area.getWidth(), area.getY() + area.getHeight(),
                    0xffb51500, 0xff600b00);
        }));
        widgets.add(Widgets.createTooltip(new Rectangle(startPoint.x + 156, startPoint.y + 11, 8, 64), Text.literal("Needs " + ((EctoplasmExtractorDisplay) display).getTotalEnergyAmount() + " E")));

        return widgets;
    }
}
