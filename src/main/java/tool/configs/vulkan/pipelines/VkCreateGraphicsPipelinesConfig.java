package tool.configs.vulkan.pipelines;

import tool.configs.Config;

/**
 * Created by kyriaki on 30/04/2016.
 */
public class VkCreateGraphicsPipelinesConfig extends Config {
    private String dynamicStatesEnables;
    private String dynamicStateCreateInfo;
    private String vertexInputStateCreateInfo;
    private String inputAssemblyStateCreateInfo;
    private String rasterisationStateCreateInfo;
    private String attachmentState;
    private String colourBlendStateCreateInfo;
    private String viewportStateCreateInfo;
    private String stencilStateCreateInfo;
    private String multisampleStateCreateInfo;
    private String shaderStages;
    private String pipelineCreateInfo;
    private String graphicsPipeline;
    private String device;
    private String cache;
    private String result;
    private String pipelineLayout;
    private String pipelineCache;
    private String vertexBindings;

    public String getVertexAttributes() {
        return vertexAttributes;
    }

    public void setVertexAttributes(String vertexAttributes) {
        this.vertexAttributes = vertexAttributes;
    }

    public String getVertexBindings() {
        return vertexBindings;
    }

    public void setVertexBindings(String vertexBindings) {
        this.vertexBindings = vertexBindings;
    }

    private String vertexAttributes;



    public String getPipelineCache() {
        return pipelineCache;
    }

    public void setPipelineCache(String pipelineCache) {
        this.pipelineCache = pipelineCache;
    }

    private String renderpass;

    public String getRenderpass() {
        return renderpass;
    }

    public void setRenderpass(String renderpass) {
        this.renderpass = renderpass;
    }

    public String getPipelineLayout() {
        return pipelineLayout;
    }

    public void setPipelineLayout(String pipelineLayout) {
        this.pipelineLayout = pipelineLayout;
    }

    public String getVertexShader() {
        return vertexShader;
    }

    public void setVertexShader(String vertexShader) {
        this.vertexShader = vertexShader;
    }

    public String getFragmentShader() {
        return fragmentShader;
    }

    public void setFragmentShader(String fragmentShader) {
        this.fragmentShader = fragmentShader;
    }

    private String vertexShader;
    private String fragmentShader;

    public String getDynamicStatesEnables() {
        return dynamicStatesEnables;
    }

    public void setDynamicStatesEnables(String dynamicStatesEnables) {
        this.dynamicStatesEnables = dynamicStatesEnables;
    }

    public String getDynamicStateCreateInfo() {
        return dynamicStateCreateInfo;
    }

    public void setDynamicStateCreateInfo(String dynamicStateCreateInfo) {
        this.dynamicStateCreateInfo = dynamicStateCreateInfo;
    }

    public String getVertexInputStateCreateInfo() {
        return vertexInputStateCreateInfo;
    }

    public void setVertexInputStateCreateInfo(String vertexInputStateCreateInfo) {
        this.vertexInputStateCreateInfo = vertexInputStateCreateInfo;
    }

    public String getInputAssemblyStateCreateInfo() {
        return inputAssemblyStateCreateInfo;
    }

    public void setInputAssemblyStateCreateInfo(String inputAssemblyStateCreateInfo) {
        this.inputAssemblyStateCreateInfo = inputAssemblyStateCreateInfo;
    }

    public String getRasterisationStateCreateInfo() {
        return rasterisationStateCreateInfo;
    }

    public void setRasterisationStateCreateInfo(String rasterisationStateCreateInfo) {
        this.rasterisationStateCreateInfo = rasterisationStateCreateInfo;
    }

    public String getAttachmentState() {
        return attachmentState;
    }

    public void setAttachmentState(String attachmentState) {
        this.attachmentState = attachmentState;
    }

    public String getColourBlendStateCreateInfo() {
        return colourBlendStateCreateInfo;
    }

    public void setColourBlendStateCreateInfo(String colourBlendStateCreateInfo) {
        this.colourBlendStateCreateInfo = colourBlendStateCreateInfo;
    }

    public String getViewportStateCreateInfo() {
        return viewportStateCreateInfo;
    }

    public void setViewportStateCreateInfo(String viewportStateCreateInfo) {
        this.viewportStateCreateInfo = viewportStateCreateInfo;
    }

    public String getStencilStateCreateInfo() {
        return stencilStateCreateInfo;
    }

    public void setStencilStateCreateInfo(String stencilStateCreateInfo) {
        this.stencilStateCreateInfo = stencilStateCreateInfo;
    }

    public String getMultisampleStateCreateInfo() {
        return multisampleStateCreateInfo;
    }

    public void setMultisampleStateCreateInfo(String multisampleStateCreateInfo) {
        this.multisampleStateCreateInfo = multisampleStateCreateInfo;
    }

    public String getShaderStages() {
        return shaderStages;
    }

    public void setShaderStages(String shaderStages) {
        this.shaderStages = shaderStages;
    }

    public String getPipelineCreateInfo() {
        return pipelineCreateInfo;
    }

    public void setPipelineCreateInfo(String pipelineCreateInfo) {
        this.pipelineCreateInfo = pipelineCreateInfo;
    }

    public String getGraphicsPipeline() {
        return graphicsPipeline;
    }

    public void setGraphicsPipeline(String graphicsPipeline) {
        this.graphicsPipeline = graphicsPipeline;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
