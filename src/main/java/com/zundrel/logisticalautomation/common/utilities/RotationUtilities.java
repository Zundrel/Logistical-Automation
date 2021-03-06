package com.zundrel.logisticalautomation.common.utilities;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;

public class RotationUtilities {
	public static AxisAlignedBB getRotatedAABB(AxisAlignedBB def, EnumFacing facing) {
		def.offset(-0.5, -0.5, -0.5);
		switch (facing) {
			case SOUTH:
				def = new AxisAlignedBB(def.minZ, def.minY, (def.maxX * -1) + 1, def.maxZ, def.maxY, (def.minX * -1) + 1);
			case WEST:
				def = new AxisAlignedBB((def.maxX * -1) + 1, def.minY, (def.maxZ * -1) + 1, (def.minX * -1) + 1, def.maxY, (def.minZ * -1) + 1);
			case EAST:
				def = new AxisAlignedBB((def.maxZ * -1) + 1, def.minY, def.minX, (def.minZ * -1) + 1, def.maxY, def.maxX);
			default:

		}
		def.offset(0.5, 0.5, 0.5);
		return def;
	}
}