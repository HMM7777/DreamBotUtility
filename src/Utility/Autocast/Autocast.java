package Utility.Autocast;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.widgets.WidgetChild;

//*********************************************************************************
// CLASS: Autocast
// The purpose of this class is to select a spell in the autocast interface.
// AUTHOR: Hmm
//*********************************************************************************
public class Autocast {

    //*********************************************************************************
    // VOID METHOD: openChooseSpell()
    // Opens the choose spell interface
    //*********************************************************************************
    public static void openChooseSpell() {
        WidgetChild autoCastInterface = Widgets.getChildWidget(201, 0);
        if (!widgetChecker(autoCastInterface)) {
            if (Tabs.open(Tab.COMBAT)) {
                WidgetChild chooseSpell = Widgets.getChildWidget(593, 26);
                if (chooseSpell.interact()) {
                    MethodProvider.sleepUntil(() -> widgetChecker(autoCastInterface) == true, 6000);
                }
            }
        }
    }

    //*********************************************************************************
    // VOID METHOD: openChooseSpellDefensive()
    // Opens the choose spell interface defensive variant.
    //*********************************************************************************
    public static void openChooseSpellDefensive() {
        WidgetChild autoCastInterface = Widgets.getChildWidget(201, 1);
        if (!widgetChecker(autoCastInterface)) {
            if (Tabs.open(Tab.COMBAT)) {
                WidgetChild chooseSpell = Widgets.getChildWidget(593, 21);
                if (chooseSpell.interact()) {
                    MethodProvider.sleepUntil(() -> widgetChecker(autoCastInterface) == true, 6000);
                }
            }
        }
    }

    //*********************************************************************************
    // BOOLEAN METHOD: widgetChecker()
    // Checks if widgetChild is available.
    //*********************************************************************************
    private static boolean widgetChecker(WidgetChild widgetChild) {
        return widgetChild != null && widgetChild.isVisible();
    }

    //*********************************************************************************
    // VOID METHOD: selectAutocastSpell()
    // Selects a spell to regular autocast.
    //*********************************************************************************
    public static void selectAutocastSpell(String spellName) {
        openChooseSpell();
        WidgetChild spell = Widgets.getMatchingWidget(w -> w != null && w.hasAction(spellName));
        if (spell.interact()) {
            WidgetChild autoCastInterface = Widgets.getChildWidget(201, 1);
            MethodProvider.sleepUntil(() -> !widgetChecker(autoCastInterface), 5000);
        }
    }

    //*********************************************************************************
    // VOID METHOD: selectAutocastSpellDefensive()
    // Selects a spell to defensive autocast.
    //*********************************************************************************
    public static void selectAutocastSpellDefensive(String spellName) {
        openChooseSpellDefensive();
        WidgetChild spell = Widgets.getMatchingWidget(w -> w != null && w.hasAction(spellName));
        if (spell.interact()) {
            WidgetChild autoCastInterface = Widgets.getChildWidget(201, 1);
            MethodProvider.sleepUntil(() -> !widgetChecker(autoCastInterface), 5000);
        }
    }

    //*********************************************************************************
    // VOID METHOD: clearSpell()
    // Clears a selected autocast spell.
    //*********************************************************************************
    public static void clearSpell() {
        openChooseSpell();
        WidgetChild cancelButton = Widgets.getMatchingWidget(w -> w != null && w.hasAction("Cancel"));
        if (cancelButton.interact()) {
            WidgetChild autoCastInterface = Widgets.getChildWidget(201, 1);
            MethodProvider.sleepUntil(() -> !widgetChecker(autoCastInterface), 5000);
        }
    }
}