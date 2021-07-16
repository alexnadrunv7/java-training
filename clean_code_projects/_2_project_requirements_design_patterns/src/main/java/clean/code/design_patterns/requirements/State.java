package clean.code.design_patterns.requirements;

class StatePattern
{
    static class FanWallControl
    {
        private SpeedLevel current;

        public FanWallControl()
        {
            current = new Off();
        }

        public void set_state(SpeedLevel state)
        {
            current = state;
        }

        public void rotate()
        {
            current.rotate(this);
        }

        @Override
        public String toString()
        {
            return String.format("Fan Wall Control [current = %s]", current);
        }
    }

    interface SpeedLevel
    {
        void rotate(FanWallControl fanWallControl);
    }

    static class Off implements SpeedLevel
    {
        public void rotate(FanWallControl fanWallControl)
        {
            fanWallControl.set_state(new SpeedLevel1());
        }
    }

    static class SpeedLevel1 implements SpeedLevel
    {
        public void rotate(FanWallControl fanWallControl)
        {
            fanWallControl.set_state(new SpeedLevel2());
        }
    }

    static class SpeedLevel2 implements SpeedLevel
    {
        public void rotate(FanWallControl fanWallControl)
        {
            fanWallControl.set_state(new SpeedLevel3());
        }
    }

    static class SpeedLevel3 implements SpeedLevel
    {
        public void rotate(FanWallControl fanWallControl)
        {
            fanWallControl.set_state(new Off());
        }
    }
}