package com.notyteam.bee.databinding;
import com.notyteam.bee.R;
import com.notyteam.bee.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(7);
        sIncludes.setIncludes(0, 
            new String[] {"app_bar_main"},
            new int[] {1},
            new int[] {com.notyteam.bee.R.layout.app_bar_main});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relat_main, 2);
        sViewsWithIds.put(R.id.frame_container, 3);
        sViewsWithIds.put(R.id.left_drawer, 4);
        sViewsWithIds.put(R.id.header, 5);
        sViewsWithIds.put(R.id.bootomm, 6);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.notyteam.bee.databinding.AppBarMainBinding) bindings[1]
            , (android.widget.LinearLayout) bindings[6]
            , (androidx.drawerlayout.widget.DrawerLayout) bindings[0]
            , (android.widget.FrameLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.RelativeLayout) bindings[4]
            , (android.widget.RelativeLayout) bindings[2]
            );
        this.drawerLayoutMain.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        appBarLayout.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (appBarLayout.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewmodel_draweritems == variableId) {
            setViewmodelDraweritems((com.notyteam.bee.core.ui.drawer.DrawerItemsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodelDraweritems(@Nullable com.notyteam.bee.core.ui.drawer.DrawerItemsViewModel ViewmodelDraweritems) {
        this.mViewmodelDraweritems = ViewmodelDraweritems;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        appBarLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeAppBarLayout((com.notyteam.bee.databinding.AppBarMainBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeAppBarLayout(com.notyteam.bee.databinding.AppBarMainBinding AppBarLayout, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(appBarLayout);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): appBarLayout
        flag 1 (0x2L): viewmodel_draweritems
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}