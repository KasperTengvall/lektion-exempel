package fi.arcada.codechallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataItemViewAdapter extends RecyclerView.Adapter<DataItemViewAdapter.DataItemViewHolder> {

    ArrayList<DataItem> dataItems;
    Context context;

    public DataItemViewAdapter(Context context, ArrayList<DataItem> dataItems) {
        this.context = context;
        this.dataItems = dataItems;

    }

    @NonNull
    @Override
    public DataItemViewAdapter.DataItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new DataItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DataItemViewAdapter.DataItemViewHolder holder, int position) {
        DataItem item = dataItems.get(position);

        holder.itemName.setText(item.getName());
        holder.itemValue.setText(String.format("%.2f", item.getValue()));

    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class DataItemViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemValue;

        public DataItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.dataItemName);
            itemValue = itemView.findViewById(R.id.dataItemValue);
        }
    }
}
