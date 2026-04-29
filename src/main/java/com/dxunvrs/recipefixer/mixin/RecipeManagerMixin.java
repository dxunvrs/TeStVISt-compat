package com.dxunvrs.recipefixer.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RecipeManagerMixin.class)
public class RecipeManagerMixin {
    @Inject(method = "apply", at = @At("HEAD"))
    private void onApply(Map<ResourceLocation, JsonElement> map,
                         ResourceManager resourceManager,
                         ProfilerFiller profilerFiller,
                         CallbackInfo callbackInfo) {
        map.entrySet().removeIf(entry -> {
            JsonElement json = entry.getValue();
            if (!json.isJsonObject()) return false;

            JsonObject object = json.getAsJsonObject();

            if (object.has("type") && object.get("type").getAsString().equals("create:filling")) {
                String content = object.toString();
                return content.contains("immersiveengineering:treated_wood_horizontal") ||
                        content.contains("immersiveengineering:treated_wood_vertical");
            }

            return false;
        });
    }
}
