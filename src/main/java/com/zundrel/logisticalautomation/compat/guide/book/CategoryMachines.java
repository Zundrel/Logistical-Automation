package com.zundrel.logisticalautomation.compat.guide.book;

import amerifrance.guideapi.api.IPage;
import amerifrance.guideapi.api.impl.abstraction.EntryAbstract;
import amerifrance.guideapi.api.util.PageHelper;
import amerifrance.guideapi.api.util.TextHelper;
import amerifrance.guideapi.entry.EntryItemStack;
import amerifrance.guideapi.page.PageText;
import com.zundrel.logisticalautomation.common.info.ModInfo;
import com.zundrel.logisticalautomation.common.registry.BlockRegistry;
import com.zundrel.logisticalautomation.common.registry.ItemRegistry;
import com.zundrel.logisticalautomation.compat.guide.BookUtils;
import com.zundrel.logisticalautomation.compat.guide.entry.EntryText;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CategoryMachines {
    public static Map<ResourceLocation, EntryAbstract> buildCategory() {
               Map<ResourceLocation, EntryAbstract> entries = new LinkedHashMap<>();
        String keyBase = "guide." + ModInfo.MOD_ID + ".entry.machines.";

        List<IPage> introPages = new ArrayList<>();
        introPages.addAll(PageHelper.pagesForLongText(TextHelper.localize(keyBase + "intro" + ".info"), 370));
        entries.put(new ResourceLocation(keyBase + "intro"), new EntryText(introPages, TextHelper.localize(keyBase + "intro"), true));

        for (Entry<ResourceLocation, EntryAbstract> entry : entries.entrySet()) {
            for (IPage page : entry.getValue().pageList) {
                if (page instanceof PageText) {
                    ((PageText) page).setUnicodeFlag(true);
                }
            }
        }

        return entries;
    }
}