package com.example.oa.adminpage.presenter.fragment;

import android.support.v4.app.Fragment;

import com.example.oa.adminpage.presenter.di.HasComponent;

/**
 * Created by Phoenix on 5/25/17.
 */

public abstract class BaseFragment extends Fragment {
    public static final String TYPE = "type_fragment";

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
