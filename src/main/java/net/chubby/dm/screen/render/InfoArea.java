package net.chubby.dm.screen.render;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Rect2i;
import net.minecraft.text.Text;
import org.apache.logging.log4j.core.config.builder.api.Component;

import java.util.List;

public abstract class InfoArea
{
    protected final Rect2i area;

    protected InfoArea(Rect2i area) {
        this.area = area;
    }

    public abstract void draw(DrawContext stack);
}