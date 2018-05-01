package com.kingslayer.whatsappclone.camera

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kingslayer.whatsappclone.R

class CameraFragment : Fragment()/* , TextureView.SurfaceTextureListener*/{

    /*private lateinit var mCameraManager: CameraManager
    private lateinit var mCameraDevice: CameraDevice
    private lateinit var mCameraCharacteristics: CameraCharacteristics
    private lateinit var mCameraId : String
    private lateinit var imageDimension : Size
    private lateinit var cameraCaptureSessions : CameraCaptureSession
    private val REQUEST_CAMERA_PERMISSION = 200*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.camera_fragment, container, false)

        /*mCameraManager = activity?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        mCameraId = mCameraManager.cameraIdList[0]
        mCameraCharacteristics = mCameraManager.getCameraCharacteristics(mCameraId)

        root.mCameraTextureView.surfaceTextureListener = this@CameraFragment*/

        return root
    }

    /*override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {
    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean = false

    override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {
        openCamera()
    }

    private fun openCamera() {
        try {
            imageDimension = mCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP).getOutputSizes(SurfaceTexture::class.java)[0]

            if(ActivityCompat.checkSelfPermission(this.context!!, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(activity!!, arrayOf(Manifest.permission.CAMERA), REQUEST_CAMERA_PERMISSION)
                return
            }
            mCameraManager.openCamera(mCameraId, object : CameraDevice.StateCallback() {
                override fun onOpened(camera: CameraDevice?) {
                    mCameraDevice = camera!!
                    //createCameraPreview()
                }

                override fun onDisconnected(camera: CameraDevice?) {
                    mCameraDevice.close()
                }

                override fun onError(camera: CameraDevice?, error: Int) {
                    mCameraDevice.close()
                }
            }, null)
        }catch (e : Exception)
        {
            Log.e("Camera", e.localizedMessage)
        }
    }

    /*@SuppressLint("Recycle")
    private fun createCameraPreview() {
        try {
            val texture = root.mCameraTextureView.surfaceTexture
            texture.setDefaultBufferSize(imageDimension.width, imageDimension.height)
            val surface = Surface(texture)

            mCameraDevice.createCaptureSession(Arrays.asList(surface), object : CameraCaptureSession.StateCallback(){
                override fun onConfigureFailed(session: CameraCaptureSession?) {
                    Toast.makeText(this@CameraFragment.context, "Something went wrong", Toast.LENGTH_LONG).show()
                }

                override fun onConfigured(session: CameraCaptureSession?) {
                    cameraCaptureSessions = session!!
                }
            }, null)
        }catch (e : Exception)
        {
            Log.e("Camera", e.localizedMessage)
        }
    }*/

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        if(requestCode == REQUEST_CAMERA_PERMISSION)
        {
            if(grantResults[0] == PackageManager.PERMISSION_DENIED)
            {
                Toast.makeText(context, "Haha! Bummer!", Toast.LENGTH_LONG).show()
            }
        }

    }*/
}
