package com.example.movieslistjetpack.di;

import android.content.Context;

import com.example.movieslistjetpack.data.source.CatalogueRepository;
import com.example.movieslistjetpack.data.source.remote.RemoteDataSource;
import com.example.movieslistjetpack.utils.JsonHelper;

public class Injection {
    public static CatalogueRepository provideRepository(Context context){
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));
        return CatalogueRepository.getINSTANCE(remoteDataSource);
    }
}
