package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentScheduleBindingImpl extends FragmentScheduleBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ivAddEvent, 1);
        sViewsWithIds.put(R.id.llForPlayerMessage, 2);
        sViewsWithIds.put(R.id.tvForPlayerMessage, 3);
        sViewsWithIds.put(R.id.tvForPlayer, 4);
        sViewsWithIds.put(R.id.lLayoutAddEvent, 5);
        sViewsWithIds.put(R.id.tvName, 6);
        sViewsWithIds.put(R.id.btnAddEvent, 7);
        sViewsWithIds.put(R.id.rLayoutAddAnEvent, 8);
        sViewsWithIds.put(R.id.rl_top, 9);
        sViewsWithIds.put(R.id.tvAdd, 10);
        sViewsWithIds.put(R.id.radioGroup, 11);
        sViewsWithIds.put(R.id.rdbGame, 12);
        sViewsWithIds.put(R.id.rdbPractice, 13);
        sViewsWithIds.put(R.id.rdbOther, 14);
        sViewsWithIds.put(R.id.rl_otherEvents, 15);
        sViewsWithIds.put(R.id.et_otherEvent, 16);
        sViewsWithIds.put(R.id.view, 17);
        sViewsWithIds.put(R.id.llDate, 18);
        sViewsWithIds.put(R.id.edtChooseDate, 19);
        sViewsWithIds.put(R.id.view1, 20);
        sViewsWithIds.put(R.id.llTime, 21);
        sViewsWithIds.put(R.id.edtChooseTime, 22);
        sViewsWithIds.put(R.id.view2, 23);
        sViewsWithIds.put(R.id.llVs, 24);
        sViewsWithIds.put(R.id.tvVS, 25);
        sViewsWithIds.put(R.id.edtVS, 26);
        sViewsWithIds.put(R.id.llLocation, 27);
        sViewsWithIds.put(R.id.tvLocation, 28);
        sViewsWithIds.put(R.id.edtLocation, 29);
        sViewsWithIds.put(R.id.tvCancel, 30);
        sViewsWithIds.put(R.id.btnAdd, 31);
        sViewsWithIds.put(R.id.ivAddEventClose, 32);
        sViewsWithIds.put(R.id.recyclerView, 33);
        sViewsWithIds.put(R.id.ivAddEventList, 34);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentScheduleBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 35, sIncludes, sViewsWithIds));
    }
    private FragmentScheduleBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[31]
            , (android.widget.Button) bindings[7]
            , (android.widget.FrameLayout) bindings[0]
            , (android.widget.EditText) bindings[19]
            , (android.widget.EditText) bindings[22]
            , (android.widget.EditText) bindings[29]
            , (android.widget.EditText) bindings[26]
            , (android.widget.EditText) bindings[16]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[32]
            , (android.widget.ImageView) bindings[34]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[27]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[24]
            , (android.widget.RelativeLayout) bindings[8]
            , (android.widget.RadioGroup) bindings[11]
            , (android.widget.RadioButton) bindings[12]
            , (android.widget.RadioButton) bindings[14]
            , (android.widget.RadioButton) bindings[13]
            , (android.support.v7.widget.RecyclerView) bindings[33]
            , (android.widget.RelativeLayout) bindings[15]
            , (android.widget.RelativeLayout) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[25]
            , (android.view.View) bindings[17]
            , (android.view.View) bindings[20]
            , (android.view.View) bindings[23]
            );
        this.container.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}