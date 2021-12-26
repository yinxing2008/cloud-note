package cn.hsp.blog.viewmodel

import androidx.lifecycle.MutableLiveData
import cn.hsp.blog.base.BaseViewModel
import cn.hsp.blog.network.BlogRepo
import cn.hsp.blog.network.response.Blog

/**
 * 厦门大学计算机专业 | 前华为工程师
 * 分享编程技术，没啥深度，但看得懂，适合初学者。
 * Java | 安卓 | 前端 | 小程序 | 鸿蒙
 * 公众号：花生皮编程
 */
class BlogViewModel : BaseViewModel() {
    private val blogListRepo by lazy { BlogRepo() }
    val blog: MutableLiveData<Blog> = MutableLiveData()

    fun getBlog(
        blogId: Long,
        onSuccess: (() -> Unit)? = null,
        onFailure: ((msg: String) -> Unit)? = null,
        onComplete: (() -> Unit)? = null
    ) {
        launch(
            {
                blog.value = blogListRepo.getBlog(blogId)?.data
                onSuccess?.invoke()
            },
            { onFailure?.invoke(it.message ?: "") },
            { onComplete?.invoke() })
    }


    fun addBlog(
        title: String,
        content: String,
        onSuccess: (() -> Unit)? = null,
        onFailure: ((msg: String) -> Unit)? = null,
        onComplete: (() -> Unit)? = null
    ) {
        launch(
            {
                blogListRepo.addBlog(title, content)
                onSuccess?.invoke()
            },
            { onFailure?.invoke(it.message ?: "") },
            { onComplete?.invoke() })
    }

    fun modifyBlog(
        id: Long,
        title: String,
        content: String,
        onSuccess: (() -> Unit)? = null,
        onFailure: ((msg: String) -> Unit)? = null,
        onComplete: (() -> Unit)? = null
    ) {
        launch(
            {
                blogListRepo.modifyBlog(id, title, content)
                onSuccess?.invoke()
            },
            { onFailure?.invoke(it.message ?: "") },
            { onComplete?.invoke() })
    }

    fun delBlog(
        blogId: Long,
        onSuccess: (() -> Unit)? = null,
        onFailure: ((msg: String) -> Unit)? = null,
        onComplete: (() -> Unit)? = null
    ) {
        launch(
            {
                blogListRepo.delBlog(blogId)
                onSuccess?.invoke()
            },
            { onFailure?.invoke(it.message ?: "") },
            { onComplete?.invoke() })
    }
}