package com.zundrel.logisticalautomation.common.handler;

import java.util.HashMap;

import com.zundrel.logisticalautomation.client.gui.GuiExtractor;
import com.zundrel.logisticalautomation.common.blocks.tiles.TileEntityExtractor;
import com.zundrel.logisticalautomation.common.containers.ContainerExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zundrel.logisticalautomation.client.gui.GuiFilter;
import com.zundrel.logisticalautomation.common.blocks.tiles.TileEntityFilter;
import com.zundrel.logisticalautomation.common.containers.ContainerFilter;

public class GuiHandler implements IGuiHandler {
	public static HashMap guiScreens = new HashMap();
	public static HashMap containers = new HashMap();

	@SideOnly(Side.CLIENT)
	private static void initGuiScreens(EntityPlayer player, World world, BlockPos pos, TileEntity tileEntity) {
		if (tileEntity instanceof TileEntityFilter) {
			guiScreens.put(0, new GuiFilter(new ContainerFilter((TileEntityFilter) tileEntity, player)));
		}

		if (tileEntity instanceof TileEntityExtractor) {
			guiScreens.put(1, new GuiExtractor(new ContainerExtractor((TileEntityExtractor) tileEntity, player)));
		}
	}

	private static void initContainers(EntityPlayer player, World world, BlockPos pos, TileEntity tileEntity) {
		if (tileEntity instanceof TileEntityFilter) {
			containers.put(0, new ContainerFilter((TileEntityFilter) tileEntity, player));
		}

		if (tileEntity instanceof TileEntityExtractor) {
			containers.put(1, new ContainerExtractor((TileEntityExtractor) tileEntity, player));
		}
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		initContainers(player, world, new BlockPos(x, y, z), world.getTileEntity(new BlockPos(x, y, z)));

		if (containers.containsKey(ID)) {
			return containers.get(ID);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		initGuiScreens(player, world, new BlockPos(x, y, z), world.getTileEntity(new BlockPos(x, y, z)));

		if (guiScreens.containsKey(ID)) {
			return guiScreens.get(ID);
		}

		return null;
	}
}
