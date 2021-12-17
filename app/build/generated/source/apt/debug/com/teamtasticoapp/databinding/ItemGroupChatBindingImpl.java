package com.teamtasticoapp.databinding;
import com.teamtasticoapp.R;
import com.teamtasticoapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemGroupChatBindingImpl extends ItemGroupChatBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.container, 1);
        sViewsWithIds.put(R.id.llChatSender, 2);
        sViewsWithIds.put(R.id.llChatSen, 3);
        sViewsWithIds.put(R.id.llSender, 4);
        sViewsWithIds.put(R.id.tvTimeSender, 5);
        sViewsWithIds.put(R.id.tvNameSender, 6);
        sViewsWithIds.put(R.id.tvMessageSender, 7);
        sViewsWithIds.put(R.id.ivTeamMemberSender, 8);
        sViewsWithIds.put(R.id.ivSender, 9);
        sViewsWithIds.put(R.id.llChatReceiver, 10);
        sViewsWithIds.put(R.id.llChatRece, 11);
        sViewsWithIds.put(R.id.ivTeamMemberReceiver, 12);
        sViewsWithIds.put(R.id.tvNameReceiver, 13);
        sViewsWithIds.put(R.id.tvTimeReceiver, 14);
        sViewsWithIds.put(R.id.tvMessageReceiver, 15);
        sViewsWithIds.put(R.id.ivReceiver, 16);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemGroupChatBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ItemGroupChatBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[9]
            , (net.grobas.view.PolygonImageView) bindings[12]
            , (net.grobas.view.PolygonImageView) bindings[8]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[5]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
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