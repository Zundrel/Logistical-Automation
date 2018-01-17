package com.zundrel.logisticalautomation.client;

import com.zundrel.logisticalautomation.common.handler.ConfigHandler;
import com.zundrel.logisticalautomation.common.info.ModInfo;
import com.zundrel.logisticalautomation.common.registry.BlockRegistry;
import com.zundrel.logisticalautomation.common.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class LogisticCreativeTabs {

    public static class LogisticGeneralTab extends CreativeTabs {
        public static LogisticGeneralTab INSTANCE = new LogisticGeneralTab();
        NonNullList<ItemStack> list;

        private LogisticGeneralTab() {
            super(ModInfo.MOD_ID + "_general");
        }

        @Override
        @Nonnull
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemRegistry.logistic_wrench);
        }

        @Override
        public void displayAllRelevantItems(@Nonnull NonNullList<ItemStack> list) {
            this.list = list;

            this.addItem(ItemRegistry.logistic_wrench);

            this.addBlock(Blocks.BONE_BLOCK);
        }

        private void addItem(Item item) {
            item.getSubItems(this, list);
        }

        private void addBlock(Block block) {
            block.getSubBlocks(this, list);
        }
    }

    public static class LogisticConveyorTab extends CreativeTabs {
        public static LogisticConveyorTab INSTANCE = new LogisticConveyorTab();
        NonNullList<ItemStack> list;

        private LogisticConveyorTab() {
            super(ModInfo.MOD_ID + "_conveyor");
        }

        @Override
        @Nonnull
        public ItemStack getTabIconItem() {
            return new ItemStack(BlockRegistry.conveyor_normal);
        }

        @Override
        public void displayAllRelevantItems(@Nonnull NonNullList<ItemStack> list) {
            this.list = list;

            this.addItem(Items.APPLE);

            this.addBlock(BlockRegistry.conveyor_normal);
            this.addBlock(BlockRegistry.conveyor_fast);
            this.addBlock(BlockRegistry.conveyor_express);

            if (ConfigHandler.enableInverseConveyors) {
                this.addBlock(BlockRegistry.conveyor_inverse_normal);
                this.addBlock(BlockRegistry.conveyor_inverse_normal);
                this.addBlock(BlockRegistry.conveyor_inverse_normal);
            }

            this.addBlock(BlockRegistry.conveyor_stair_normal);
            this.addBlock(BlockRegistry.conveyor_stair_fast);
            this.addBlock(BlockRegistry.conveyor_stair_express);

            this.addBlock(BlockRegistry.conveyor_stair_down_normal);
            this.addBlock(BlockRegistry.conveyor_stair_down_fast);
            this.addBlock(BlockRegistry.conveyor_stair_down_express);

            this.addBlock(BlockRegistry.conveyor_vertical_normal);
            this.addBlock(BlockRegistry.conveyor_vertical_fast);
            this.addBlock(BlockRegistry.conveyor_vertical_express);

            this.addBlock(BlockRegistry.filter);
            this.addBlock(BlockRegistry.splitter);
            this.addBlock(BlockRegistry.junction);
        }

        private void addItem(Item item) {
            item.getSubItems(this, list);
        }

        private void addBlock(Block block) {
            block.getSubBlocks(this, list);
        }
    }

}