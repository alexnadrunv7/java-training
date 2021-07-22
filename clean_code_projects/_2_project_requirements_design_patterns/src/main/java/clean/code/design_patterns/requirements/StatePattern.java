package clean.code.design_patterns.requirements;

class StatePattern
{
    static class GearBox
    {
        private SpeedLevel current;

        public GearBox()
        {
            current = new Off();
        }

        public void setState(SpeedLevel state)
        {
            current = state;
        }

        public void press()
        {
            current.press(this);
        }

        @Override
        public String toString()
        {
            return String.format("Current gear is [current = %s]", current);
        }
    }

    interface SpeedLevel
    {
        void press(GearBox gearBox);
    }

    static class Off implements SpeedLevel
    {
        public void press(GearBox gearBox)
        {
            gearBox.setState(new SpeedLevel1());
        }
    }

    static class SpeedLevel1 implements SpeedLevel
    {
        public void press(GearBox gearBox)
        {
            gearBox.setState(new SpeedLevel2());
        }
    }

    static class SpeedLevel2 implements SpeedLevel
    {
        public void press(GearBox gearBox)
        {
            gearBox.setState(new SpeedLevel3());
        }
    }

    static class SpeedLevel3 implements SpeedLevel
    {
        public void press(GearBox gearBox)
        {
            gearBox.setState(new SpeedLevel4());
        }
    }

    static class SpeedLevel4 implements SpeedLevel
    {
        public void press(GearBox gearBox)
        {
            gearBox.setState(new SpeedLevel5());
        }
    }

    static class SpeedLevel5 implements SpeedLevel
    {
        public void press(GearBox gearBox)
        {
            gearBox.setState(new SpeedLevel6());
        }
    }

    static class SpeedLevel6 implements SpeedLevel
    {
        public void press(GearBox gearBox)
        {
            gearBox.setState(new Off());
        }
    }
}