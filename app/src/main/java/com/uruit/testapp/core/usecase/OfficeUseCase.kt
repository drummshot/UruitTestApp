package com.uruit.testapp.core.usecase

import android.os.Handler
import androidx.lifecycle.LiveData
import com.uruit.testapp.core.data.dao.OfficeDao
import com.uruit.testapp.core.data.realm.Office
import io.realm.RealmResults
import kotlin.random.Random


const val DEFAULT_NUMBER_OF_PERSONS: Int = 50
const val MAX_NUMBER_OF_PERSONS: Int = 100
const val MIN_NUMBER_OF_PERSONS: Int = 0

const val NAME_KEY : String = "NAME"
const val PEOPLE_KEY : String = "PEOPLE"
const val OFFICE_KEY : String ="OFFICE"

const val MAX_NUMBER_OF_OFFICES: Int = 100

class OfficeUseCase(val officeDao: OfficeDao) : UseCase {


    val updateHandler = Handler()

    private val background = object: Runnable {

        override fun run() {
            updateNumberOfPersons()
            updateHandler.postDelayed(this, 5000)
        }
    }

    init {
        fillOffices()
        background.run()
    }

    fun getOffices(lessThan: Boolean): LiveData<RealmResults<Office>> {
        return officeDao.query(if(lessThan) 0 else 50, if(lessThan) 50 else 100)
    }


    private fun fillOffices() {
        for (i in officeDao.count().toInt() .. MAX_NUMBER_OF_OFFICES) {
            val office = Office(i, "$OFFICE_KEY $i", DEFAULT_NUMBER_OF_PERSONS)
            officeDao.save(office)
        }
    }


    fun updateNumberOfPersons() {
        if (officeDao.count() > 0)
            for (i in 1 .. MAX_NUMBER_OF_OFFICES) {
                val office = officeDao.getCopyById(i)
                var addSubstract: Int = if(Random.nextInt(0, 100) < 50) -1 else 1


                if (office?.peopleInOffice!! == MAX_NUMBER_OF_PERSONS) {
                    addSubstract = -1
                } else if (office.peopleInOffice == MIN_NUMBER_OF_PERSONS) {
                    addSubstract = 1
                }

                office.peopleInOffice = office.peopleInOffice + addSubstract
                officeDao.save(office)
            }
    }

}


