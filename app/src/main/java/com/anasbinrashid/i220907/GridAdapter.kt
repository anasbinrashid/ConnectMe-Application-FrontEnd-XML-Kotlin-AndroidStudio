import com.anasbinrashid.i220907.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class GridAdapter(private val context: Context, private val imageList: List<Int>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return imageList.size
    }

    override fun getItem(position: Int): Any {
        return imageList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.griditem, parent, false)
        }

        val imageView = convertView!!.findViewById<ImageView>(R.id.gridImage)
        imageView.setImageResource(imageList[position])

        return convertView
    }
}