package com.example.avelon;

import java.util.List;
import java.util.Random;

public class SetRoleHandler {
    private List<User> users;
    private boolean percivalFlag = false;
    private boolean merlinFlag = false;
    private boolean assasinFlag = false;
    private boolean mordredFlag = false;
    private boolean morganaFlag = false;
    private int numberOfServent = 0;
    private boolean serventFlag = false;
    private Random rd = new Random();

    public SetRoleHandler(List<User> users) {
        this.users = users;
    }

    public List<User> setRoleUser() {

        int size = users.size();

        for (int i = 0; i < size; i++) {
            setRoleConstraint(users.get(i));
        }
        return users;
    }

    private void setRoleConstraint(User user) {
        boolean roleSeted = false;
        int randomNumber = rd.nextInt() % users.size();
        if (randomNumber == 0 && !percivalFlag) {
            percivalFlag = true;
            user.setRole("PERCIVAL");
            return;
        }
        if (randomNumber == 1 && !merlinFlag) {
            merlinFlag = true;
            user.setRole("MERLIN");
            return;
        }
        if (randomNumber == 2 && !morganaFlag) {
            morganaFlag = true;
            user.setRole("MORGANA");
            return;
        }
        if (randomNumber == 3 && !assasinFlag) {
            assasinFlag = true;
            user.setRole("ASSASIN");
            return;
        }
        if (users.size() == 5) {
            if (randomNumber == 4) {
                serventFlag = true;
                user.setRole("SERVENT");
                return;
            }
        }
        if (users.size() == 6) {
            if (numberOfServent < 2) {
                if (randomNumber == 4 || randomNumber == 5) {
                    numberOfServent += 1;
                    user.setRole("SERVENT");
                    return;
                }
            }

        }
        if (users.size() == 7) {
            if (randomNumber == 4 || randomNumber == 5) {
                if (numberOfServent < 2) {
                    numberOfServent += 1;
                    user.setRole("SERVENT");
                    return;
                }
            }
            if (randomNumber == 6 && !mordredFlag) {
                mordredFlag = true;
                user.setRole("MORDRED");
                return;
            }

        }
        if (users.size() == 8) {
            if (randomNumber == 4 || randomNumber == 5 || randomNumber == 8) {
                if (numberOfServent < 3) {
                    numberOfServent += 1;
                    user.setRole("SERVENT");
                    return;
                }
            }
            if (randomNumber == 6 && !mordredFlag) {
                mordredFlag = true;
                user.setRole("MORDRED");
                return;
            }

        }
        if (users.size() == 9) {
            if (randomNumber == 4 || randomNumber == 5 || randomNumber == 9 || randomNumber == 8) {
                if (numberOfServent < 4) {
                    numberOfServent += 1;
                    user.setRole("SERVENT");
                    return;
                }

            }
            if (randomNumber == 6 && !mordredFlag) {
                mordredFlag = true;
                user.setRole("MORDRED");
                return;

            }

        }
        if (users.size() == 10) {
            //TODO
            return;

        }
        setRoleConstraint(user);

    }
}
