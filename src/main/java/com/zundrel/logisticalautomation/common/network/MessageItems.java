package com.zundrel.logisticalautomation.common.network;

import com.zundrel.logisticalautomation.LogisticalAutomation;
import com.zundrel.logisticalautomation.common.capability.CapabilityTesting;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageItems implements IMessage, IMessageHandler<MessageItems, IMessage> {
    NBTTagCompound nbt;

    public MessageItems() {
    }

    public MessageItems(NBTTagCompound nbt) {
        this.nbt = nbt;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        nbt = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, nbt);
    }

    @Override
    public IMessage onMessage(MessageItems message, MessageContext ctx) {
        EntityPlayer player = LogisticalAutomation.proxy.getPlayerEntity(ctx);

        CapabilityTesting test = player.world.getCapability(LogisticalAutomation.TEST_DATA, null);

        test.deserializeNBT(message.nbt);

        return null;
    }

}