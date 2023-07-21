package com.ranaturker.task3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ranaturker.task3.part1.CounterFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //Activity'nin görsel düzenini belirler

        // Fragment'ı ekleyelim
        if (savedInstanceState == null) { //Activity'nin ilk kez oluşturulma durumunu kontrol eder
            supportFragmentManager.beginTransaction() //Fragmentları yönetmek için kullanılan işlem nesnesi
                //fragmentContainer içinde başka bir Fragment varsa, onu CounterFragment ile değiştirir
                .replace(R.id.fragmentContainer, CounterFragment())
                .commit() //FragmentTransaction'ı uygular
        }
    }
}
/*MainActivity'deki bu kod, uygulamanın başlangıcında CounterFragment'ı fragmentContainer
adlı bir yere ekleyerek kullanıcının sayaç ekranını görmesini sağlar.
Eğer zaten bir Fragment varsa, onu CounterFragment ile değiştirir.
Bu sayede kullanıcının sayaç değerini artırması ve cihazı döndürmesi durumunda sayaç değerinin
korunması sağlanır.
 */
