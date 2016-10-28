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
        addValueChangeListenerToParent()
    }

    private addValueChangeListenerToParent() {
        parent.addValueChangeListener(new ParentValueChangeListener(childAttribute: childAttribute, child: child))
    }
}

class ParentValueChangeListener implements Component.ValueChangeListener {

    PickerField child
    String childAttribute

    @Override
    void valueChanged(Component.ValueChangeEvent e) {
        e.value ? valueChangedNewValue(e.value) : valueChangedEmptyNewValue()
    }

    private void valueChangedEmptyNewValue() {
        child.value = null
    }

    private void valueChangedNewValue(newValue) {
        enableDisableChild(newValue)
        setChildLookupParams(newValue)
    }

    private void setChildLookupParams(def value) {
        LinkedHashMap lookupScreenParams = getLookupScreenParams(value)
        PickerField.LookupAction childLookupAction = child.getAction("lookup")
        childLookupAction.lookupScreenParams = lookupScreenParams
    }

    private LinkedHashMap getLookupScreenParams(def value) {
        value ? ["$childAttribute":value]  : [:]
    }

    private void enableDisableChild(def value) {
        child.setEnabled(value ? true : false)
    }
}