/*
 * TODO Copyright
 */

package com.company.cech.web.lineitem

import com.company.cech.web.ControllerHelper
import com.haulmont.cuba.gui.components.PickerField

class DependentPickerFieldHelperSpec extends spock.lang.Specification {

    ControllerHelper dependentPickerFieldHelper

    def "dependentPickerFieldHelper deaktiviert den Child picker"() {

        given:

        PickerField parent = Mock(PickerField)
        PickerField child = Mock(PickerField)

        dependentPickerFieldHelper = new DependentPickerFieldHelper(
                parent: parent,
                child: child,
                childAttribute: "test"
        )

        when:
        dependentPickerFieldHelper.init()

        then:
        1 * child.setEnabled(false)

    }
}
