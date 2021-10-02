package com.imeja.jetpackfirebase.data
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.Query.*
import com.google.firebase.firestore.Query.Direction.*
import com.imeja.jetpackfirebase.utility.Constants.NAME_PROPERTY
import com.imeja.jetpackfirebase.utility.Constants.PRODUCTS_COLLECTION
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideQueryProductsByName() = FirebaseFirestore.getInstance()
        .collection(PRODUCTS_COLLECTION)
        .orderBy(NAME_PROPERTY, ASCENDING)
}