public class EnumTester {

    private enum Alphabet {A, B, C}

    public enum WeekDays {
        SUNDAY(true), MONDAY(false), TUESDAY(false), WEDNESDAY(false), THURSDAY(false), FRIDAY(false), SATURDAY(true);

        private final boolean weekend;

        WeekDays(boolean weekend) {
            this.weekend = weekend;
        }

        public boolean isWeekend() {
            return weekend;
        }
    }

    private void weekDayTester() {
        System.out.println("Saturday is a weekend day? " + WeekDays.SATURDAY.isWeekend());
    }

    private void switchTester() {
        Alphabet letter = Alphabet.A;
        switch(letter) {
            case A:
                System.out.println("A");
                break;
            case B:
                System.out.println("B");
                break;
            default:
                System.out.println("Unknown");
        }
    }



    public static void main(String[] args) {
        EnumTester enumTester = new EnumTester();
        enumTester.switchTester();

        enumTester.weekDayTester();
    }
}