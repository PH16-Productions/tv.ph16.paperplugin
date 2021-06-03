package tv.ph16.paperplugin;

import java.util.Optional;

import javax.annotation.Generated;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

/**
 * Provides wrapper for configuration.
 * <p>
 * Primary gain is by returning {@link Optional}.
 *
 * @author Shmueli Englard
 * @see Configuration
 * @see Plugin#getConfig()
 */
@Generated(value = "T4", date = "2021-06-03T04:33:41")
public abstract class ConfigurationManager {
    @NotNull
    private final Plugin plugin;
    @NotNull
    private Configuration config;

    /**
     * Create a new instance of the {@link ConfigurationMananger} class.
     * @param plugin The plugin to manage configuration for.
     */
    protected ConfigurationManager(@NotNull Plugin plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();
    }

    /**
     * Save the configuration.
     */
    public final void save() {
        plugin.saveConfig();
    }

    /**
     * Reload configuration.
     */
    public final void reload() {
        plugin.reloadConfig();
        config = plugin.getConfig();
    }

    /**
     * Sets or remove a path.
     * @param <T> Type of configuration.
     * @param path Path of the value to set or remove.
     * @param value If {@link Optional#empty()}, removes configuration; otherwise is set.
     */
    private final <T> void set(@NotNull String path, @NotNull Optional<T> value) {
        if (value.isPresent()) {
            config.set(path, value.get());
        } else {
            config.set(path, null);
        }
    }

    /**
     * Remove a path.
     * @param path Path to remove.
     */
    protected final void remove(@NotNull String path) {
        set(path, Optional.empty());
    }

    /**
     * Gets the requested object by path.
     * @param path Path of the object to get.
     * @return If configuration exists and is an object, the requested object; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final <T extends ConfigurationSerializable> Optional<T> getObject(@NotNull String path, @NotNull Class<T> clazz) {
        ConfigurationSerialization.registerClass(clazz);
        if (config.contains(path, true)) {
            return Optional.ofNullable(config.getObject(path, clazz, null));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested object by path.
     * @param path Path of the object to get.
     * @param defaultValue The default value to return if the path is not found or is not an object.
     * @return Requested object.
     */
    @NotNull
    protected final <T extends ConfigurationSerializable> T getObject(@NotNull String path, @NotNull Class<T> clazz, @NotNull T defaultValue) {
        return getObject(path, clazz).orElse(defaultValue);
    }

    /**
     * Sets an object by path.
     * @param path Path of the object to set.
     * @param value {@link Optional#empty()} to remove or the Object to set.
     */
    protected final <T extends ConfigurationSerializable> void setObject(@NotNull String path, @NotNull Optional<T> value) {
        set(path, value);
    }

    /**
     * Sets an object by path.
     * @param path Path of the object to set.
     * @param value The Object to set.
     */
    protected final <T extends ConfigurationSerializable> void setObject(@NotNull String path, @NotNull T value) {
        set(path, Optional.of(value));
    }

        /**
     * Gets the requested int by path.
     * @param path Path of the int to get.
     * @return If configuration exists and is a int, the requested int; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<Integer> getInt(@NotNull String path) {
        if (config.contains(path, true) && config.isInt(path)) {
            return Optional.of(config.getInt(path));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested int by path.
     * @param path Path of the int to get.
     * @param defaultValue The default value to return if the path is not found or is not a int.
     * @return Requested int.
     */
    @NotNull
    protected final int getInt(@NotNull String path, int defaultValue) {
        return getInt(path).orElse(defaultValue);
    }

    /**
     * Sets a int by path.
     * @param path Path of the int to set.
     * @param value The int to set.
     */
    protected final void setInt(@NotNull String path, int value) {
        set(path, Optional.of(value));
    }

    /**
     * Sets a int by path.
     * @param path Path of the int to set.
     * @param value {@link Optional#empty()} to remove or the int to set.
     */
    protected final void setInt(@NotNull String path, @NotNull Optional<Integer> value) {
        set(path, value);
    }
        /**
     * Gets the requested boolean by path.
     * @param path Path of the boolean to get.
     * @return If configuration exists and is a boolean, the requested boolean; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<Boolean> getBoolean(@NotNull String path) {
        if (config.contains(path, true) && config.isBoolean(path)) {
            return Optional.of(config.getBoolean(path));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested boolean by path.
     * @param path Path of the boolean to get.
     * @param defaultValue The default value to return if the path is not found or is not a boolean.
     * @return Requested boolean.
     */
    @NotNull
    protected final boolean getBoolean(@NotNull String path, boolean defaultValue) {
        return getBoolean(path).orElse(defaultValue);
    }

    /**
     * Sets a boolean by path.
     * @param path Path of the boolean to set.
     * @param value The boolean to set.
     */
    protected final void setBoolean(@NotNull String path, boolean value) {
        set(path, Optional.of(value));
    }

    /**
     * Sets a boolean by path.
     * @param path Path of the boolean to set.
     * @param value {@link Optional#empty()} to remove or the boolean to set.
     */
    protected final void setBoolean(@NotNull String path, @NotNull Optional<Boolean> value) {
        set(path, value);
    }
        /**
     * Gets the requested double by path.
     * @param path Path of the double to get.
     * @return If configuration exists and is a double, the requested double; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<Double> getDouble(@NotNull String path) {
        if (config.contains(path, true) && config.isDouble(path)) {
            return Optional.of(config.getDouble(path));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested double by path.
     * @param path Path of the double to get.
     * @param defaultValue The default value to return if the path is not found or is not a double.
     * @return Requested double.
     */
    @NotNull
    protected final double getDouble(@NotNull String path, double defaultValue) {
        return getDouble(path).orElse(defaultValue);
    }

    /**
     * Sets a double by path.
     * @param path Path of the double to set.
     * @param value The double to set.
     */
    protected final void setDouble(@NotNull String path, double value) {
        set(path, Optional.of(value));
    }

    /**
     * Sets a double by path.
     * @param path Path of the double to set.
     * @param value {@link Optional#empty()} to remove or the double to set.
     */
    protected final void setDouble(@NotNull String path, @NotNull Optional<Double> value) {
        set(path, value);
    }
        /**
     * Gets the requested String by path.
     * @param path Path of the String to get.
     * @return If configuration exists and is a String, the requested String; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<String> getString(@NotNull String path) {
        if (config.contains(path, true) && config.isString(path)) {
            return Optional.of(config.getString(path));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested String by path.
     * @param path Path of the String to get.
     * @param defaultValue The default value to return if the path is not found or is not a String.
     * @return Requested String.
     */
    @NotNull
    protected final String getString(@NotNull String path, String defaultValue) {
        return getString(path).orElse(defaultValue);
    }

    /**
     * Sets a String by path.
     * @param path Path of the String to set.
     * @param value The String to set.
     */
    protected final void setString(@NotNull String path, String value) {
        set(path, Optional.of(value));
    }

    /**
     * Sets a String by path.
     * @param path Path of the String to set.
     * @param value {@link Optional#empty()} to remove or the String to set.
     */
    protected final void setString(@NotNull String path, @NotNull Optional<String> value) {
        set(path, value);
    }
        /**
     * Gets the requested long by path.
     * @param path Path of the long to get.
     * @return If configuration exists and is a long, the requested long; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<Long> getLong(@NotNull String path) {
        if (config.contains(path, true) && config.isLong(path)) {
            return Optional.of(config.getLong(path));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested long by path.
     * @param path Path of the long to get.
     * @param defaultValue The default value to return if the path is not found or is not a long.
     * @return Requested long.
     */
    @NotNull
    protected final long getLong(@NotNull String path, long defaultValue) {
        return getLong(path).orElse(defaultValue);
    }

    /**
     * Sets a long by path.
     * @param path Path of the long to set.
     * @param value The long to set.
     */
    protected final void setLong(@NotNull String path, long value) {
        set(path, Optional.of(value));
    }

    /**
     * Sets a long by path.
     * @param path Path of the long to set.
     * @param value {@link Optional#empty()} to remove or the long to set.
     */
    protected final void setLong(@NotNull String path, @NotNull Optional<Long> value) {
        set(path, value);
    }
        /**
     * Gets the requested Color by path.
     * @param path Path of the Color to get.
     * @return If configuration exists and is a Color, the requested Color; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<Color> getColor(@NotNull String path) {
        if (config.contains(path, true) && config.isColor(path)) {
            return Optional.of(config.getColor(path));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested Color by path.
     * @param path Path of the Color to get.
     * @param defaultValue The default value to return if the path is not found or is not a Color.
     * @return Requested Color.
     */
    @NotNull
    protected final Color getColor(@NotNull String path, Color defaultValue) {
        return getColor(path).orElse(defaultValue);
    }

    /**
     * Sets a Color by path.
     * @param path Path of the Color to set.
     * @param value The Color to set.
     */
    protected final void setColor(@NotNull String path, Color value) {
        set(path, Optional.of(value));
    }

    /**
     * Sets a Color by path.
     * @param path Path of the Color to set.
     * @param value {@link Optional#empty()} to remove or the Color to set.
     */
    protected final void setColor(@NotNull String path, @NotNull Optional<Color> value) {
        set(path, value);
    }
        /**
     * Gets the requested Location by path.
     * @param path Path of the Location to get.
     * @return If configuration exists and is a Location, the requested Location; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<Location> getLocation(@NotNull String path) {
        if (config.contains(path, true) && config.isLocation(path)) {
            return Optional.of(config.getLocation(path));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested Location by path.
     * @param path Path of the Location to get.
     * @param defaultValue The default value to return if the path is not found or is not a Location.
     * @return Requested Location.
     */
    @NotNull
    protected final Location getLocation(@NotNull String path, Location defaultValue) {
        return getLocation(path).orElse(defaultValue);
    }

    /**
     * Sets a Location by path.
     * @param path Path of the Location to set.
     * @param value The Location to set.
     */
    protected final void setLocation(@NotNull String path, Location value) {
        set(path, Optional.of(value));
    }

    /**
     * Sets a Location by path.
     * @param path Path of the Location to set.
     * @param value {@link Optional#empty()} to remove or the Location to set.
     */
    protected final void setLocation(@NotNull String path, @NotNull Optional<Location> value) {
        set(path, value);
    }
        /**
     * Gets the requested OfflinePlayer by path.
     * @param path Path of the OfflinePlayer to get.
     * @return If configuration exists and is a OfflinePlayer, the requested OfflinePlayer; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<OfflinePlayer> getOfflinePlayer(@NotNull String path) {
        if (config.contains(path, true) && config.isOfflinePlayer(path)) {
            return Optional.of(config.getOfflinePlayer(path));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested OfflinePlayer by path.
     * @param path Path of the OfflinePlayer to get.
     * @param defaultValue The default value to return if the path is not found or is not a OfflinePlayer.
     * @return Requested OfflinePlayer.
     */
    @NotNull
    protected final OfflinePlayer getOfflinePlayer(@NotNull String path, OfflinePlayer defaultValue) {
        return getOfflinePlayer(path).orElse(defaultValue);
    }

    /**
     * Sets a OfflinePlayer by path.
     * @param path Path of the OfflinePlayer to set.
     * @param value The OfflinePlayer to set.
     */
    protected final void setOfflinePlayer(@NotNull String path, OfflinePlayer value) {
        set(path, Optional.of(value));
    }

    /**
     * Sets a OfflinePlayer by path.
     * @param path Path of the OfflinePlayer to set.
     * @param value {@link Optional#empty()} to remove or the OfflinePlayer to set.
     */
    protected final void setOfflinePlayer(@NotNull String path, @NotNull Optional<OfflinePlayer> value) {
        set(path, value);
    }
        /**
     * Gets the requested ItemStack by path.
     * @param path Path of the ItemStack to get.
     * @return If configuration exists and is a ItemStack, the requested ItemStack; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<ItemStack> getItemStack(@NotNull String path) {
        if (config.contains(path, true) && config.isItemStack(path)) {
            return Optional.of(config.getItemStack(path));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested ItemStack by path.
     * @param path Path of the ItemStack to get.
     * @param defaultValue The default value to return if the path is not found or is not a ItemStack.
     * @return Requested ItemStack.
     */
    @NotNull
    protected final ItemStack getItemStack(@NotNull String path, ItemStack defaultValue) {
        return getItemStack(path).orElse(defaultValue);
    }

    /**
     * Sets a ItemStack by path.
     * @param path Path of the ItemStack to set.
     * @param value The ItemStack to set.
     */
    protected final void setItemStack(@NotNull String path, ItemStack value) {
        set(path, Optional.of(value));
    }

    /**
     * Sets a ItemStack by path.
     * @param path Path of the ItemStack to set.
     * @param value {@link Optional#empty()} to remove or the ItemStack to set.
     */
    protected final void setItemStack(@NotNull String path, @NotNull Optional<ItemStack> value) {
        set(path, value);
    }
        /**
     * Gets the requested Vector by path.
     * @param path Path of the Vector to get.
     * @return If configuration exists and is a Vector, the requested Vector; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<Vector> getVector(@NotNull String path) {
        if (config.contains(path, true) && config.isVector(path)) {
            return Optional.of(config.getVector(path));
        }
        return Optional.empty();
    }

    /**
     * Gets the requested Vector by path.
     * @param path Path of the Vector to get.
     * @param defaultValue The default value to return if the path is not found or is not a Vector.
     * @return Requested Vector.
     */
    @NotNull
    protected final Vector getVector(@NotNull String path, Vector defaultValue) {
        return getVector(path).orElse(defaultValue);
    }

    /**
     * Sets a Vector by path.
     * @param path Path of the Vector to set.
     * @param value The Vector to set.
     */
    protected final void setVector(@NotNull String path, Vector value) {
        set(path, Optional.of(value));
    }

    /**
     * Sets a Vector by path.
     * @param path Path of the Vector to set.
     * @param value {@link Optional#empty()} to remove or the Vector to set.
     */
    protected final void setVector(@NotNull String path, @NotNull Optional<Vector> value) {
        set(path, value);
    }
    
}