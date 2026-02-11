package com.Custom.Alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class ShowCustomAlert {
    /**
     * Menampilkan dialog
     *
     * @param context Context dari Activity atau Fragment
     */
    public static void show(Context context) {
        show(context, "Request Gagal, tidak dapat terhubung ke server.\nPeriksa koneksi internet Anda!");
    }

    /**
     * Menampilkan dialog dengan pesan kustom
     *
     * @param context Context dari Activity atau Fragment
     * @param message Pesan yang akan ditampilkan
     */
    public static void show(Context context, String message) {
        View dialog = LayoutInflater.from(context).inflate(R.layout.dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.setView(dialog);

        ConstraintLayout card = dialog.findViewById(R.id.card);
        TextView txtVersion = dialog.findViewById(R.id.txtVersion);
        ImageView image = dialog.findViewById(R.id.image);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        TextView txtMessage = dialog.findViewById(R.id.txtMessage);
        Button button = dialog.findViewById(R.id.button);

        // Set version name
        setVersionName(context, txtVersion);

        // Set message
        txtMessage.setText(message);

        final AlertDialog failure = alertDialog.create();
        failure.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        failure.setCancelable(false);
        failure.show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                failure.dismiss();
            }
        });
    }

    /**
     * Menampilkan dialog dengan listener saat tombol close ditekan
     *
     * @param context  Context dari Activity atau Fragment
     * @param listener OnDismissListener untuk menangani event saat dialog ditutup
     */
    public static void show(Context context, OnDismissListener listener) {
        show(context, "Request Gagal, tidak dapat terhubung ke server.\nPeriksa koneksi internet Anda!", listener);
    }

    /**
     * Menampilkan dialog dengan pesan kustom dan listener
     *
     * @param context  Context dari Activity atau Fragment
     * @param message  Pesan yang akan ditampilkan
     * @param listener OnDismissListener untuk menangani event saat dialog ditutup
     */
    public static void show(Context context, String message, OnDismissListener listener) {
        View dialog = LayoutInflater.from(context).inflate(R.layout.dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.setView(dialog);

        ConstraintLayout card = dialog.findViewById(R.id.card);
        TextView txtVersion = dialog.findViewById(R.id.txtVersion);
        ImageView image = dialog.findViewById(R.id.image);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        TextView txtMessage = dialog.findViewById(R.id.txtMessage);
        Button button = dialog.findViewById(R.id.button);

        // Set version name
        setVersionName(context, txtVersion);

        // Set message
        txtMessage.setText(message);

        final AlertDialog failure = alertDialog.create();
        failure.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        failure.setCancelable(false);
        failure.show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                failure.dismiss();
                if (listener != null) {
                    listener.onDismiss();
                }
            }
        });
    }

    /**
     * Mengatur nama versi aplikasi pada TextView
     */
    private static void setVersionName(Context context, TextView txtVersion) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            String versionName = packageInfo.versionName;
            txtVersion.setText("V." + versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            txtVersion.setText("");
        }
    }

    /**
     * Interface untuk listener saat dialog ditutup
     */
    public interface OnDismissListener {
        void onDismiss();
    }

    /**
     * Builder untuk membuat dialog dengan kustomisasi lebih lanjut
     */
    public static class Builder {
        private Context context;
        private String message = "Request Gagal, tidak dapat terhubung ke server.\nPeriksa koneksi internet Anda!";
        private String title = "";
        private Drawable cardBackground;
        private Drawable buttonBackground;
        private Integer buttonTextColor;
        private Drawable imageDrawable;
        private Integer imageResource;
        private OnDismissListener dismissListener;

        /**
         * Membuat Builder baru
         *
         * @param context Context dari Activity atau Fragment
         */
        public Builder(Context context) {
            this.context = context;
        }

        /**
         * Mengatur pesan dialog
         *
         * @param message Pesan yang akan ditampilkan
         * @return Builder
         */
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * Mengatur judul dialog
         *
         * @param title Judul yang akan ditampilkan
         * @return Builder
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Mengatur background card
         *
         * @param background Drawable untuk background card
         * @return Builder
         */
        public Builder setCardBackground(Drawable background) {
            this.cardBackground = background;
            return this;
        }

        /**
         * Mengatur background card dengan resource color
         *
         * @param colorRes Resource color untuk background card
         * @return Builder
         */
        public Builder setCardBackgroundColor(int colorRes) {
            this.cardBackground = ContextCompat.getDrawable(context, colorRes);
            return this;
        }

        /**
         * Mengatur background tombol
         *
         * @param background Drawable untuk background tombol
         * @return Builder
         */
        public Builder setButtonBackground(Drawable background) {
            this.buttonBackground = background;
            return this;
        }

        /**
         * Mengatur background tombol dengan resource color
         *
         * @param colorRes Resource color untuk background tombol
         * @return Builder
         */
        public Builder setButtonBackgroundColor(int colorRes) {
            this.buttonBackground = ContextCompat.getDrawable(context, colorRes);
            return this;
        }

        /**
         * Mengatur warna text tombol
         *
         * @param color Warna text tombol (Color.INT)
         * @return Builder
         */
        public Builder setButtonTextColor(int color) {
            this.buttonTextColor = color;
            return this;
        }

        /**
         * Mengatur warna text tombol dengan resource color
         *
         * @param colorRes Resource color untuk text tombol
         * @return Builder
         */
        public Builder setButtonTextColorResource(int colorRes) {
            this.buttonTextColor = ContextCompat.getColor(context, colorRes);
            return this;
        }

        /**
         * Mengatur listener saat dialog ditutup
         *
         * @param listener OnDismissListener untuk menangani event saat dialog ditutup
         * @return Builder
         */
        public Builder setOnDismissListener(OnDismissListener listener) {
            this.dismissListener = listener;
            return this;
        }

        /**
         * Mengatur gambar ImageView
         *
         * @param drawable Drawable untuk gambar
         * @return Builder
         */
        public Builder setImageDrawable(Drawable drawable) {
            this.imageDrawable = drawable;
            return this;
        }

        /**
         * Mengatur gambar ImageView dengan resource drawable
         *
         * @param resId Resource drawable untuk gambar
         * @return Builder
         */
        public Builder setImageResource(int resId) {
            this.imageResource = resId;
            return this;
        }

        /**
         * Menampilkan dialog
         */
        public void show() {
            View dialog = LayoutInflater.from(context).inflate(R.layout.dialog, null);
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

            alertDialog.setView(dialog);

            ConstraintLayout card = dialog.findViewById(R.id.card);
            TextView txtVersion = dialog.findViewById(R.id.txtVersion);
            ImageView image = dialog.findViewById(R.id.image);
            TextView txtTitle = dialog.findViewById(R.id.txtTitle);
            TextView txtMessage = dialog.findViewById(R.id.txtMessage);
            Button button = dialog.findViewById(R.id.button);

            // Set version name
            setVersionName(context, txtVersion);

            // Set title
            if (!title.isEmpty()) {
                txtTitle.setText(title);
                txtTitle.setVisibility(View.VISIBLE);
            } else {
                txtTitle.setVisibility(View.GONE);
            }

            // Set message
            txtMessage.setText(message);

            // Set card background
            if (cardBackground != null) {
                card.setBackground(cardBackground);
            }

            // Set button background
            if (buttonBackground != null) {
                button.setBackground(buttonBackground);
            }

            // Set button text color
            if (buttonTextColor != null) {
                button.setTextColor(buttonTextColor);
            }

            // Set image
            if (imageDrawable != null) {
                image.setImageDrawable(imageDrawable);
            }
            if (imageResource != null) {
                image.setImageResource(imageResource);
            }

            final AlertDialog failure = alertDialog.create();
            failure.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            failure.setCancelable(false);
            failure.show();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    failure.dismiss();
                    if (dismissListener != null) {
                        dismissListener.onDismiss();
                    }
                }
            });
        }

        /**
         * Mengatur nama versi aplikasi pada TextView
         */
        private void setVersionName(Context context, TextView txtVersion) {
            PackageManager packageManager = context.getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                String versionName = packageInfo.versionName;
                txtVersion.setText("V." + versionName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                txtVersion.setText("");
            }
        }
    }
}
