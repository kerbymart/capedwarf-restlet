package org.example.client.local;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.Label;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.Composite;
/**
 * @author kerymart
 * @version 0.0.1
 * @since 0.0.1
 */
@Dependent
@Templated("#welcome")
@Page(role = DefaultPage.class)
public class WelcomePage extends Composite {
    @Inject
    @DataField
    Label text;

    @PostConstruct
    public void buildUI(){
        text.setText("This text is from Errai/GWT!");
    }
}
