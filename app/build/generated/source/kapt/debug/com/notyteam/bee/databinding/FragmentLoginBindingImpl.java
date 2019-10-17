package com.notyteam.bee.databinding;
import com.notyteam.bee.R;
import com.notyteam.bee.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentLoginBindingImpl extends FragmentLoginBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.btn_fragment_login_in, 5);
        sViewsWithIds.put(R.id.tv_login_forget_password, 6);
        sViewsWithIds.put(R.id.tv_login_enter_to_you_account, 7);
        sViewsWithIds.put(R.id.guideline9, 8);
        sViewsWithIds.put(R.id.guideline10, 9);
        sViewsWithIds.put(R.id.guideline8, 10);
        sViewsWithIds.put(R.id.guideline6, 11);
        sViewsWithIds.put(R.id.guideline7, 12);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    private AfterTextChangedImpl mModelOnEmailChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private AfterTextChangedImpl1 mModelOnPasswordChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener editTextEmailandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.email
            //         is model.setEmail((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextEmail);
            // localize variables for thread safety
            // model
            com.notyteam.bee.registration.login.viewmodel.LoginViewModel model = mModel;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.email
            java.lang.String modelEmail = null;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {




                model.setEmail(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener editTextPasswordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.password
            //         is model.setPassword((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editTextPassword);
            // localize variables for thread safety
            // model
            com.notyteam.bee.registration.login.viewmodel.LoginViewModel model = mModel;
            // model.password
            java.lang.String modelPassword = null;
            // model != null
            boolean modelJavaLangObjectNull = false;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {




                model.setPassword(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.Button) bindings[5]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[9]
            , (androidx.constraintlayout.widget.Guideline) bindings[11]
            , (androidx.constraintlayout.widget.Guideline) bindings[12]
            , (androidx.constraintlayout.widget.Guideline) bindings[10]
            , (androidx.constraintlayout.widget.Guideline) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[1]
            , (com.google.android.material.textfield.TextInputLayout) bindings[3]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[6]
            );
        this.editTextEmail.setTag(null);
        this.editTextPassword.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textInputLayoutEmail.setTag(null);
        this.textInputLayoutPassword.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((com.notyteam.bee.registration.login.viewmodel.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.notyteam.bee.registration.login.viewmodel.LoginViewModel Model) {
        updateRegistration(0, Model);
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModel((com.notyteam.bee.registration.login.viewmodel.LoginViewModel) object, fieldId);
            case 1 :
                return onChangeModelErrorEmailMessage((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeModelErrorPasswordMessage((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModel(com.notyteam.bee.registration.login.viewmodel.LoginViewModel Model, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.email) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.password) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelErrorEmailMessage(androidx.databinding.ObservableField<java.lang.String> ModelErrorEmailMessage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelErrorPasswordMessage(androidx.databinding.ObservableField<java.lang.String> ModelErrorPasswordMessage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        com.notyteam.bee.registration.login.viewmodel.LoginViewModel model = mModel;
        androidx.databinding.ObservableField<java.lang.String> modelErrorEmailMessage = null;
        androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged modelOnEmailChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = null;
        java.lang.String modelErrorEmailMessageGet = null;
        androidx.databinding.ObservableField<java.lang.String> modelErrorPasswordMessage = null;
        androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged modelOnPasswordChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = null;
        java.lang.String modelEmail = null;
        java.lang.String modelErrorPasswordMessageGet = null;
        java.lang.String modelPassword = null;
        android.view.View.OnFocusChangeListener modelGetPasswordOnFocusChangeListener = null;
        android.view.View.OnFocusChangeListener modelGetEmailOnFocusChangeListener = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x23L) != 0) {

                    if (model != null) {
                        // read model.errorEmailMessage
                        modelErrorEmailMessage = model.getErrorEmailMessage();
                    }
                    updateRegistration(1, modelErrorEmailMessage);


                    if (modelErrorEmailMessage != null) {
                        // read model.errorEmailMessage.get()
                        modelErrorEmailMessageGet = modelErrorEmailMessage.get();
                    }
            }
            if ((dirtyFlags & 0x21L) != 0) {

                    if (model != null) {
                        // read model::onEmailChanged
                        modelOnEmailChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = (((mModelOnEmailChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged == null) ? (mModelOnEmailChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = new AfterTextChangedImpl()) : mModelOnEmailChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged).setValue(model));
                        // read model::onPasswordChanged
                        modelOnPasswordChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = (((mModelOnPasswordChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged == null) ? (mModelOnPasswordChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = new AfterTextChangedImpl1()) : mModelOnPasswordChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged).setValue(model));
                        // read model.getPasswordOnFocusChangeListener()
                        modelGetPasswordOnFocusChangeListener = model.getPasswordOnFocusChangeListener();
                        // read model.getEmailOnFocusChangeListener()
                        modelGetEmailOnFocusChangeListener = model.getEmailOnFocusChangeListener();
                    }
            }
            if ((dirtyFlags & 0x25L) != 0) {

                    if (model != null) {
                        // read model.errorPasswordMessage
                        modelErrorPasswordMessage = model.getErrorPasswordMessage();
                    }
                    updateRegistration(2, modelErrorPasswordMessage);


                    if (modelErrorPasswordMessage != null) {
                        // read model.errorPasswordMessage.get()
                        modelErrorPasswordMessageGet = modelErrorPasswordMessage.get();
                    }
            }
            if ((dirtyFlags & 0x29L) != 0) {

                    if (model != null) {
                        // read model.email
                        modelEmail = model.getEmail();
                    }
            }
            if ((dirtyFlags & 0x31L) != 0) {

                    if (model != null) {
                        // read model.password
                        modelPassword = model.getPassword();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextEmail, modelEmail);
        }
        if ((dirtyFlags & 0x21L) != 0) {
            // api target 1

            com.notyteam.bee.utils.BindingUtils.bindFocusChange(this.editTextEmail, modelGetEmailOnFocusChangeListener);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextEmail, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)modelOnEmailChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged, editTextEmailandroidTextAttrChanged);
            com.notyteam.bee.utils.BindingUtils.bindFocusChange(this.editTextPassword, modelGetPasswordOnFocusChangeListener);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editTextPassword, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)modelOnPasswordChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged, editTextPasswordandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextPassword, modelPassword);
        }
        if ((dirtyFlags & 0x23L) != 0) {
            // api target 1

            com.notyteam.bee.utils.BindingUtils.errorMessage(this.textInputLayoutEmail, modelErrorEmailMessageGet);
        }
        if ((dirtyFlags & 0x25L) != 0) {
            // api target 1

            com.notyteam.bee.utils.BindingUtils.errorMessage(this.textInputLayoutPassword, modelErrorPasswordMessageGet);
        }
    }
    // Listener Stub Implementations
    public static class AfterTextChangedImpl implements androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged{
        private com.notyteam.bee.registration.login.viewmodel.LoginViewModel value;
        public AfterTextChangedImpl setValue(com.notyteam.bee.registration.login.viewmodel.LoginViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void afterTextChanged(android.text.Editable arg0) {
            this.value.onEmailChanged(arg0); 
        }
    }
    public static class AfterTextChangedImpl1 implements androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged{
        private com.notyteam.bee.registration.login.viewmodel.LoginViewModel value;
        public AfterTextChangedImpl1 setValue(com.notyteam.bee.registration.login.viewmodel.LoginViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void afterTextChanged(android.text.Editable arg0) {
            this.value.onPasswordChanged(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): model.errorEmailMessage
        flag 2 (0x3L): model.errorPasswordMessage
        flag 3 (0x4L): model.email
        flag 4 (0x5L): model.password
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}