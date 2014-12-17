package org.example.client.local;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.*;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

/**
 * Application bootstrap
 * 
 * @author kerymart
 * @version 0.0.1
 * @since 0.0.1
 */
@Templated("#main")
@ApplicationScoped
@EntryPoint
public class Bootstrap extends Composite
{
	
    @Inject
    Navigation navigation;

    @Inject
    @DataField
    Label text;
    
    @Inject @DataField
    private SimplePanel content;
    
    @PostConstruct
    public void buildUI()
    {
    	content.add(navigation.getContentPanel());
        text.setText("This text is from Errai/GWT!");
        RootPanel.get("rootPanel").add(this);
    }

}
