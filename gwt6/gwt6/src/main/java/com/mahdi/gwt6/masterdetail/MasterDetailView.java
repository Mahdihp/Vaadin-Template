package com.mahdi.gwt6.masterdetail;

import com.mahdi.gwt6.MainView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "master-detail", layout = MainView.class)
@PageTitle("Master-Detail")
@CssImport("styles/shared-styles.css")
public class MasterDetailView extends Div implements AfterNavigationObserver {


    private TextField firstname = new TextField();
    private TextField lastname = new TextField();
    private TextField email = new TextField();
    private PasswordField password = new PasswordField();

    public MasterDetailView() {
        setId("master-detail-view");


        Div editorDiv = new Div();
        editorDiv.setId("editor-layout");
        getButton(editorDiv);

        add(editorDiv);
    }

    private void getButton(Div editorDiv) {
        Button cancel = new Button("انصراف");
        cancel.setId("btnCancel");
        Button save = new Button("تایید");
        save.getElement().getStyle().set("font-family", "Vazir");
        save.getElement().getStyle().set("font-size", "25px");
        cancel.getElement().getStyle().set("font-size", "25px");
        cancel.getElement().getStyle().set("font-family", "Vazir");
        save.addClickListener(e -> {
            Notification.show("Not implemented");
        });

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setSpacing(false);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        buttonLayout.add(cancel, save);
        editorDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("wrapper");
        wrapper.setWidthFull();
        splitLayout.addToPrimary(wrapper);
    }

    private void addFormItem(Div wrapper, FormLayout formLayout,
                             AbstractField field, String fieldName) {
        formLayout.addFormItem(field, fieldName);
        wrapper.add(formLayout);
        field.getElement().getClassList().add("full-width");
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {

        // Lazy init of the grid items, happens only when we are sure the view will be
        // shown to the user

    }

}
