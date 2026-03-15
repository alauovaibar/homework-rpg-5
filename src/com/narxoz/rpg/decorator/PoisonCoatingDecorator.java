package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        // TODO: Decide how this decorator changes the visible action name.
        return "Отравленный"+super.getActionName();
    }

    @Override
    public int getDamage() {
        // TODO: Add poison-related behavior on top of wrapped damage.
        return super.getDamage() + 5;
    }

    @Override
    public String getEffectSummary() {
        // TODO: Append or compose the poison effect description.
        return super.getEffectSummary() + ", накладывает яд (+5 урона)";
    }
}
