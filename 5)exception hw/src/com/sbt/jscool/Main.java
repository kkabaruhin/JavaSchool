package com.sbt.jscool;

public class Main {

    public static class user {
        public int age;


        public int checkAge(int x) {
            return age;
        }
    }

    public class AccountIsLockedException extends Exception {

        AccountIsLockedException(int time) {
            super("Вы ввели пин-код неправильно 3 раза подряд. До разблокировки " + time + " секунд");
        }

    }

    public interface Terminal {
        public void check_account();

        public void put(int count) throws Exception;

        public void withdraw(int count) throws Exception;
    }

    public class TerminalServer {
        private int account;

        public TerminalServer(){
            account = 0;
        }

        public int check_account() {
            return account;
        };

        public void put(int count) throws Exception {
            if (count % 100 != 0) {
                throw new Exception("Неудача. Класть на счет можно только суммы, кратные 100, хз почему.");
            }
            account = account + count;
        };

        public void withdraw(int count) throws Exception{
            if (count % 100 != 0) {
                throw new Exception("Неудача. Снимать со счета можно только суммы, кратные 100, хз почему.");
            }
            account = account - count;
        };
    }

    public class PinValidator {
        int pin;

        public PinValidator() {
            pin = 0;
        }

        void change_pin(int old_pin, int new_pin) throws Exception {
            if (pin != old_pin) {
                throw new Exception("Неверно введен старый пин");
            }
            pin = new_pin;
        }

        boolean access(int in_pin) {
            if (pin == in_pin) {
                return true;
            }
            return false;
        }
    }

    public class TerminalImpl implements Terminal {

        private final TerminalServer server;
        private final PinValidator pinValidator;
        private int current_pin;

        public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
            this.server = server;
            this.pinValidator = pinValidator;
        }

        public TerminalImpl(){
            this.server = new TerminalServer();
            this.pinValidator = new PinValidator();
        }

        public void change_pin_on_server(int old_pin, int new_pin)throws Exception{
            pinValidator.change_pin(old_pin, new_pin);
        }

        public void in_pin(int pin){
            current_pin = pin;
        }

        @Override
        public void check_account() {
            if (pinValidator.access(current_pin)){
                System.out.println(server.check_account());
            }
        }

        @Override
        public void put(int count) throws Exception {
            if (pinValidator.access(current_pin)) {
                server.put(count);
            }
        }

        @Override
        public void withdraw(int count) throws Exception {

        }
    }

    public static void main(String[] args) {
        // write your code here
    }
}
