package tv.ph16.paperplugin;

import java.util.Optional;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * Provides wrapper for configuration.
 * <p>
 * Primary gain is by returning {@link Optional}.
 *
 * @author Shmueli Englard
 * @see Configuration
 * @see Plugin#getConfig()
 */
public abstract class ConfigurationManager {
    @NotNull
    private final Plugin plugin;
    @NotNull
    private Configuration config;

    /**
     * Create a new instance of the {@link ConfigurationMananger} class.
     * @param plugin The plugin to manage configuration for.
     */
    public ConfigurationManager(@NotNull Plugin plugin) {
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
     * Gets the requested int by path.
     * @param path Path of the int to get.
     * @return If configuration exists and is an int, the requested int; otherwise {@link Optional#empty()}.
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
     * @param defaultValue The default value to return if the path is not found or is not an int.
     * @return Requested int.
     */
    protected final int getInt(@NotNull String path, int defaultValue) {
        return getInt(path).orElse(defaultValue);
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
    protected final String getString(@NotNull String path, @NotNull String defaultValue) {
        return getString(path).orElse(defaultValue);
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
    protected final boolean getBoolean(@NotNull String path, boolean defaultValue) {
        return getBoolean(path).orElse(defaultValue);
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
    protected final double getDouble(@NotNull String path, double defaultValue) {
        return getDouble(path).orElse(defaultValue);
    }

    /**
     * Gets the requested long by path.
     * @param path Path of the long to get.
     * @return If configuration exists and is a long, the requested long; otherwise {@link Optional#empty()}.
     */
    @NotNull
    protected final Optional<Long> getLong(@NotNull String path) {
        if (config.contains(path) && config.isLong(path)) {
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
    protected final long getLong(@NotNull String path, long defaultValue) {
        return getLong(path).orElse(defaultValue);
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
     * Sets an int by path.
     * @param path Path of the int to set.
     * @param value {@link Optional#empty()} to remove or the int to set.
     */
    protected final void setInt(@NotNull String path, @NotNull Optional<Integer> value) {
        set(path, value);
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
     * Sets a boolean by path.
     * @param path Path of the boolean to set.
     * @param value {@link Optional#empty()} to remove or the boolean to set.
     */
    protected final void setBoolean(@NotNull String path, @NotNull Optional<Boolean> value) {
        set(path, value);
    }

    /**
     * Sets an object by path.
     * @param path Path of the object to set.
     * @param value {@link Optional#empty()} to remove or the Object to set.
     */
    protected final <T extends ConfigurationSerializable> void setObject(@NotNull String path, @NotNull Optional<T> value) {
        set(path, value);
    }
}
