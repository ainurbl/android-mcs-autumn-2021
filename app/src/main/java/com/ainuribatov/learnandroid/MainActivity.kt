package com.ainuribatov.learnandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.userListRecyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = ListAdapter()
        recyclerView.adapter = adapter
        adapter.userList = loadUsers()
//        adapter.pool.shutdown()
        adapter.notifyDataSetChanged()
    }

    private fun loadUsers(): List<Item> {
        return listOf(
            UserData(avatarUrl = "https://sun9-42.userapi.com/impg/wXDqM5zCAp1cfL3JJEufrAy3OZk02U_MkMfy1g/38Q0b7Rk66U.jpg?size=640x640&quality=96&sign=d921e1c194379d1e6cd5b31a29fa6a7c&type=album", userName = "Ainur", groupName = "Б09"),
            SeparatorData(),
            UserData(avatarUrl = "https://sun9-47.userapi.com/impg/SAB0k6xgXy6K55v4If8sGwHkBe_KnDqMUzPlGA/K9SnQk75wJo.jpg?size=1080x720&quality=96&sign=9c9b6b8606a5d904a3e563fb6d073235&type=album", userName = "Kirill", groupName = "Б09"),
            SeparatorData(),
            UserData(avatarUrl = "https://sun9-68.userapi.com/impg/URNfOWhWgL7sn9Im3J-EoZ_cSDNZrwm6O9YTIA/zKhCl_QYoZY.jpg?size=1620x2160&quality=96&sign=f1fb0019e91dc743c7806b06219e0418&type=album", userName = "Ilya", groupName = "ПУНК"),
            SeparatorData(),
            UserData(avatarUrl = "https://sun9-60.userapi.com/impf/c851532/v851532775/7cbbf/NJbUDXxzhSg.jpg?size=2560x1920&quality=96&sign=2c526bb3d3b93b99d3b447a94f3a27de&type=album", userName = "Rustam", groupName = "Б09"),
            SeparatorData(),
        )
    }
}