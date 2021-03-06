package tool.codegen.vulkan.enumeration;

import tool.codegen.coverage.Coverage;
import tool.codegen.vulkan.VulkanCodeGenerator;
import tool.codegen.vulkan.VulkanTemplates;
import tool.configs.Config;
import tool.configs.vulkan.VulkanGlobalState;
import tool.configs.vulkan.enumeration.VkEnumerateInstanceLayerPropertiesConfig;
import tool.fsm.vulkan.states.VulkanState;
import tool.utils.FreshMap;
import tool.utils.RandomNumberGanerator;
import tool.utils.RandomStringGenerator;

/**
 * Created by constantinos on 05/04/2016.
 */
public class VkEnumerateInstanceLayerPropertiesGenerator extends VulkanCodeGenerator {
    private final String INSTANCE_LAYER_COUNT_NAME = "instanceLayerCount";
    private final String INSTANCE_LAYER_PROPERTIES_NAME =
            "instanceLayerProperties";

    public VkEnumerateInstanceLayerPropertiesGenerator(
            RandomStringGenerator randomStringGenerator,
            RandomNumberGanerator randomNumberGanerator,
            FreshMap freshMap,
            Coverage coverage,
            VulkanGlobalState globalState) {
        super(randomStringGenerator, randomNumberGanerator, freshMap, coverage,
                VulkanTemplates.VK_ENUMERATE_INSTANCE_LAYER_PROPERTIES,
                globalState);
    }

    @Override
    public Config generateConfig() {
        VkEnumerateInstanceLayerPropertiesConfig config =
                new VkEnumerateInstanceLayerPropertiesConfig();

        // Create variable names
        config.setId(generateConfigId());
        config.setInstanceLayerCount(INSTANCE_LAYER_COUNT_NAME +
                freshMap.getFreshId(INSTANCE_LAYER_COUNT_NAME));
        config.setInstanceLayerProperties(INSTANCE_LAYER_PROPERTIES_NAME +
                freshMap.getFreshId(INSTANCE_LAYER_PROPERTIES_NAME));
        config.setResult(RESULT + freshMap.getFreshId(RESULT));

        globalState.addConfig(VulkanState.VK_ENUMERATE_INSTANCE_LAYER_PROPERTIES,
                config);

        return config;
    }
}
