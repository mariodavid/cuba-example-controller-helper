package com.company.cech.web.lineitem

import com.company.cech.web.ControllerHelper
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.PickerField

class DependentPickerFieldHelper implements ControllerHelper {

    PickerField parent

    PickerField child

    String childAttribute

    @Override
    public void init(Map<String, Object> params = [:]) {

        child.setEnabled(false)
        PickerField.LookupAction childLookupAction = child.getAction("lookup")

        parent.addValueChangeListener(new Component.ValueChangeListener() {
            @Override
            void valueChanged(Component.ValueChangeEvent e) {

                def lookupScreenParams = [:]
                boolean childEnabled = false

                if (e.value) {
                    lookupScreenParams."$childAttribute" = e.value
                    childEnabled = true
                }
                else {
                    child.value = null
                }

                child.setEnabled(childEnabled)
                childLookupAction.lookupScreenParams = lookupScreenParams

            }
        })



    }
}
