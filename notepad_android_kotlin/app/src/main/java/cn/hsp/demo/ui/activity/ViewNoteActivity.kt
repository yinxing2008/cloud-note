package cn.hsp.demo.ui.activity

import android.content.Intent
import androidx.lifecycle.Observer
import cn.hsp.demo.R
import cn.hsp.demo.base.BaseVmActivity
import cn.hsp.demo.network.response.Note
import cn.hsp.demo.utils.Constants.EXTRA_KEY_NOTE_CONTENT
import cn.hsp.demo.utils.Constants.EXTRA_KEY_NOTE_ID
import cn.hsp.demo.utils.Constants.EXTRA_KEY_NOTE_TITLE
import cn.hsp.demo.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_view_note.*

/**
 * 厦门大学计算机专业 | 前华为工程师
 * 专注《零基础学编程系列》https://cxyxy.blog.csdn.net/article/details/121134634
 * 包含：Java | 安卓 | 前端 | Flutter | iOS | 小程序 | 鸿蒙
 * 公众号：花生皮编程
 */
class ViewNoteActivity : BaseVmActivity<NoteViewModel>() {
    private var noteId = 0L
    private var note: Note? = null
    override fun viewModelClass() = NoteViewModel::class.java
    override fun layoutResId(): Int = R.layout.activity_view_note

    override fun initView() {
        noteId = intent.getLongExtra(EXTRA_KEY_NOTE_ID, 0L)
        initToolbar()
    }

    private fun initToolbar() {
        toolbar.inflateMenu(R.menu.view)
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_modify -> gotoModifyNotePage()
                R.id.action_del -> deleteData()
            }
            false
        }
    }

    private fun deleteData() {
        mViewModel.deleteData(noteId)
        finish()
    }

    private fun gotoModifyNotePage() {
        val intent = Intent(this, EditNoteActivity::class.java)
        intent.putExtra(EXTRA_KEY_NOTE_ID, note?.id)
        intent.putExtra(EXTRA_KEY_NOTE_TITLE, note?.title)
        intent.putExtra(EXTRA_KEY_NOTE_CONTENT, note?.content)
        startActivity(intent)
    }

    override fun initData() {
        mViewModel.queryData(noteId)
    }

    override fun observe() {
        mViewModel.note.observe(this, Observer {
            note = it
            titleEt.text = it.title
            contentEt.text = it.content
        }
        )
    }

    override fun onResume() {
        super.onResume()
        initData()
    }
}
