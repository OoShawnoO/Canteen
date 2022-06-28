package com.example.canteen
import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

class SetProvider: ContentProvider() {
    private val setDir = 0
    private val setItem = 1
    lateinit var utils:DBUtils
    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
    private val authority = "com.example.canteen.provider"
    init{
        uriMatcher.addURI(authority,"set",setDir)
        uriMatcher.addURI(authority,"set/#",setItem)
    }
    override fun onCreate(): Boolean {
        utils = DBUtils(context,"set.db",3)
        return true
    }
    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        var rs:Cursor? = null
        val db = utils.readableDatabase
        when(uriMatcher.match(uri)){
            setDir -> {
                rs = db.query(Set.TABLE,projection,selection,selectionArgs,null,null,sortOrder)
            }
            setItem->{
                val id = ContentUris.parseId(uri)
                rs = db.query(Set.TABLE,projection,"id=?", arrayOf(id.toString()),null,null,sortOrder)
            }
        }
        return rs
    }
    override fun getType(uri: Uri): String? {
        val dir = "vnd.android.cursor.dir/vnd.$authority.set"
        val item = "vnd.android.cursor.dir/vnd.$authority.set"
        return when(uriMatcher.match(uri)){
            setDir->dir
            setItem->item
            else-> dir
        }
    }
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        var rs:Uri? = null

        val db = utils.writableDatabase
        when(uriMatcher.match(uri)){
            setDir->{
                val id = db.insert(Set.TABLE,null,values)
                rs = Uri.parse("content://$authority/todo/$id")
            }
        }
        db.close()
        return rs
    }
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        var rs = 0
        val db = utils.writableDatabase
        when(uriMatcher.match(uri)){
//            todoDir->{}
            setItem->{
                val id = ContentUris.parseId(uri)
                rs = db.delete(Set.TABLE,"id=?", arrayOf(id.toString()))
            }
        }
        db.close()
        return rs
    }
    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }
}