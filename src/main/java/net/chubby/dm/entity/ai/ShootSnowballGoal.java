package net.chubby.dm.entity.ai;

import net.minecraft.entity.ai.goal.Goal;

public class ShootSnowballGoal extends Goal {
    @Override
    public boolean canStart() {
        return false;
    }
}
