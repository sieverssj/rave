package org.apache.rave.portal.model.impl;

import org.apache.rave.portal.model.*;

import java.util.List;

public class PageTemplateImpl implements PageTemplate {
    private String name;
    private String description;
    private PageType pageType;
    private PageTemplate parentPageTemplate;
    private List<PageTemplate> subPageTemplates;
    private PageLayout pageLayout;
    private List<PageTemplateRegion> pageTemplateRegions;
    private long renderSequence;
    private boolean defaultTemplate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PageType getPageType() {
        return pageType;
    }

    public void setPageType(PageType pageType) {
        this.pageType = pageType;
    }

    public PageTemplate getParentPageTemplate() {
        return parentPageTemplate;
    }

    public void setParentPageTemplate(PageTemplate parentPageTemplate) {
        this.parentPageTemplate = parentPageTemplate;
    }

    public List<PageTemplate> getSubPageTemplates() {
        return subPageTemplates;
    }

    public void setSubPageTemplates(List<PageTemplate> subPageTemplates) {
        this.subPageTemplates = subPageTemplates;
    }

    public PageLayout getPageLayout() {
        return pageLayout;
    }

    public void setPageLayout(PageLayout pageLayout) {
        this.pageLayout = pageLayout;
    }

    public List<PageTemplateRegion> getPageTemplateRegions() {
        return pageTemplateRegions;
    }

    public void setPageTemplateRegions(List<PageTemplateRegion> pageTemplateRegions) {
        this.pageTemplateRegions = pageTemplateRegions;
    }

    public long getRenderSequence() {
        return renderSequence;
    }

    public void setRenderSequence(long renderSequence) {
        this.renderSequence = renderSequence;
    }

    public boolean isDefaultTemplate() {
        return defaultTemplate;
    }

    public void setDefaultTemplate(boolean defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageTemplateImpl)) return false;

        PageTemplateImpl that = (PageTemplateImpl) o;

        if (defaultTemplate != that.defaultTemplate) return false;
        if (renderSequence != that.renderSequence) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pageLayout != null ? !pageLayout.equals(that.pageLayout) : that.pageLayout != null) return false;
        if (pageTemplateRegions != null ? !pageTemplateRegions.equals(that.pageTemplateRegions) : that.pageTemplateRegions != null)
            return false;
        if (pageType != that.pageType) return false;
        if (parentPageTemplate != null ? !parentPageTemplate.equals(that.parentPageTemplate) : that.parentPageTemplate != null)
            return false;
        if (subPageTemplates != null ? !subPageTemplates.equals(that.subPageTemplates) : that.subPageTemplates != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pageType != null ? pageType.hashCode() : 0);
        result = 31 * result + (parentPageTemplate != null ? parentPageTemplate.hashCode() : 0);
        result = 31 * result + (subPageTemplates != null ? subPageTemplates.hashCode() : 0);
        result = 31 * result + (pageLayout != null ? pageLayout.hashCode() : 0);
        result = 31 * result + (pageTemplateRegions != null ? pageTemplateRegions.hashCode() : 0);
        result = 31 * result + (int) (renderSequence ^ (renderSequence >>> 32));
        result = 31 * result + (defaultTemplate ? 1 : 0);
        return result;
    }
}