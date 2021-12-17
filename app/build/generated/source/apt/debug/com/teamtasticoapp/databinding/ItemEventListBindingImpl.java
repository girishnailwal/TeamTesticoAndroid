package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemEventListBindingImpl extends ItemEventListBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.llGame, 1);
        sViewsWithIds.put(R.id.tvGame, 2);
        sViewsWithIds.put(R.id.tvTeamName, 3);
        sViewsWithIds.put(R.id.tvOpponentNameGame, 4);
        sViewsWithIds.put(R.id.tvDateGame, 5);
        sViewsWithIds.put(R.id.tvTimeGame, 6);
        sViewsWithIds.put(R.id.tvLocationGame, 7);
        sViewsWithIds.put(R.id.llEditDeleteGame, 8);
        sViewsWithIds.put(R.id.tvEditGame, 9);
        sViewsWithIds.put(R.id.tvDeleteGame, 10);
        sViewsWithIds.put(R.id.llPractice, 11);
        sViewsWithIds.put(R.id.tvPractice, 12);
        sViewsWithIds.put(R.id.tvOpponentNamePractice, 13);
        sViewsWithIds.put(R.id.tvDatePractice, 14);
        sViewsWithIds.put(R.id.tvTimePractice, 15);
        sViewsWithIds.put(R.id.tvLocationPractice, 16);
        sViewsWithIds.put(R.id.llEditDeletePractice, 17);
        sViewsWithIds.put(R.id.tvEditPractice, 18);
        sViewsWithIds.put(R.id.tvDeletePractice, 19);
        sViewsWithIds.put(R.id.llOther, 20);
        sViewsWithIds.put(R.id.tvOther, 21);
        sViewsWithIds.put(R.id.tvOtherEventTitle, 22);
        sViewsWithIds.put(R.id.tvDateOther, 23);
        sViewsWithIds.put(R.id.tvTimeOther, 24);
        sViewsWithIds.put(R.id.tvLocationOther, 25);
        sViewsWithIds.put(R.id.llEditDeleteOther, 26);
        sViewsWithIds.put(R.id.tvEditOther, 27);
        sViewsWithIds.put(R.id.tvDeleteOther, 28);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemEventListBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }
    private ItemEventListBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[15]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
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