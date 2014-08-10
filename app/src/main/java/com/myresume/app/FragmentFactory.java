package com.myresume.app;

import android.support.v4.app.Fragment;

import com.myresume.app.fragments.EducationFragment;
import com.myresume.app.fragments.ExperienceFragment;
import com.myresume.app.fragments.HobbiesFragment;
import com.myresume.app.fragments.PersonalFragment;
import com.myresume.app.fragments.TechnologiesFragment;

/**
 * Created by nightrain on 09.08.14.
 */
public class FragmentFactory {
    public static final int FRAGMENT_PERSONAL = 0;
    public static final int FRAGMENT_TECHNOLOGIES = 1;
    public static final int FRAGMENT_EXPERIENCE = 2;
    public static final int FRAGMENT_EDUCATION = 3;
    public static final int FRAGMENT_HOBBIES = 4;

    public static Fragment getFragment(int fragmentType) {
        switch(fragmentType) {
            case FRAGMENT_PERSONAL:
                return new PersonalFragment();

            case FRAGMENT_TECHNOLOGIES:
                return TechnologiesFragment.newInstance();

            case FRAGMENT_EXPERIENCE:
                return ExperienceFragment.newInstance();

            case FRAGMENT_EDUCATION:
                return EducationFragment.newInstance();

            case FRAGMENT_HOBBIES:
                return HobbiesFragment.newInstance();

        }
        return null;
    }

}
