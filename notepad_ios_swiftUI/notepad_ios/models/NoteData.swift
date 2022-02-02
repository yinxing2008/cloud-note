// 厦门大学计算机专业 | 前华为工程师
// 专注《零基础学编程系列》https://cxyxy.blog.csdn.net/article/details/121134634
// 包含：Java | 安卓 | 前端 | Flutter | iOS | 小程序 | 鸿蒙
// 公众号：花生皮编程

import Foundation

class NoteData{
    static let shared = NoteData()
    private var notesStoreName = "notes"
    
    var notes:[Note] = [
        Note(text: "花生皮编程1"),
        Note(text: "花生皮编程2"),
        Note(text: "花生皮编程3")
    ]
    
    private init() { load() }
    
    func load(){
        if let data = UserDefaults.standard.object(forKey: notesStoreName) as? Data{
            self.notes = try! PropertyListDecoder().decode([Note].self, from: data)
        }
    }
    
    func save(){
        UserDefaults.standard.set(try? PropertyListEncoder().encode(notes),forKey: notesStoreName)
    }

}
