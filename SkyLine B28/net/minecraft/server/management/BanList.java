package net.minecraft.server.management;

import java.io.File;
import java.net.SocketAddress;

import com.google.gson.JsonObject;

public class BanList extends UserList
{

    public BanList(File bansFile)
    {
        super(bansFile);
    }

    protected UserListEntry createEntry(JsonObject entryData)
    {
        return new IPBanEntry(entryData);
    }

    public boolean isBanned(SocketAddress address)
    {
        String var2 = this.addressToString(address);
        return this.hasEntry(var2);
    }

    public IPBanEntry getBanEntry(SocketAddress address)
    {
        String var2 = this.addressToString(address);
        return (IPBanEntry)this.getEntry(var2);
    }

    private String addressToString(SocketAddress address)
    {
        String var2 = address.toString();

        if (var2.contains("/"))
        {
            var2 = var2.substring(var2.indexOf(47) + 1);
        }

        if (var2.contains(":"))
        {
            var2 = var2.substring(0, var2.indexOf(58));
        }

        return var2;
    }
}