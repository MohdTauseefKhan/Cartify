import { FaFacebookF, FaInstagram, FaTwitter, FaGithub } from "react-icons/fa";

export default function Footer() {
  return (
    <footer className="border-t border-zinc-200 bg-white text-zinc-900 dark:border-zinc-800 dark:bg-zinc-950 dark:text-white">
      <div className="mx-auto flex max-w-7xl flex-col gap-10 px-6 py-10 md:flex-row md:justify-between">
        {/* Brand */}
        <div className="max-w-sm space-y-3">
          <h2 className="text-2xl font-bold tracking-tight">ShopSphere</h2>

          <p className="text-sm leading-6 text-zinc-600 dark:text-zinc-400">
            Modern e-commerce experience built with React, Tailwind CSS, and
            clean minimal UI.
          </p>
        </div>

        {/* Links */}
        <div className="grid grid-cols-2 gap-10 sm:grid-cols-3">
          {/* Company */}
          <div className="space-y-3">
            <h3 className="text-sm font-semibold uppercase tracking-wider">
              Company
            </h3>

            <ul className="space-y-2 text-sm text-zinc-600 dark:text-zinc-400">
              <li className="cursor-pointer transition hover:text-black dark:hover:text-white">
                About
              </li>

              <li className="cursor-pointer transition hover:text-black dark:hover:text-white">
                Careers
              </li>

              <li className="cursor-pointer transition hover:text-black dark:hover:text-white">
                Contact
              </li>
            </ul>
          </div>

          {/* Support */}
          <div className="space-y-3">
            <h3 className="text-sm font-semibold uppercase tracking-wider">
              Support
            </h3>

            <ul className="space-y-2 text-sm text-zinc-600 dark:text-zinc-400">
              <li className="cursor-pointer transition hover:text-black dark:hover:text-white">
                Help Center
              </li>

              <li className="cursor-pointer transition hover:text-black dark:hover:text-white">
                Returns
              </li>

              <li className="cursor-pointer transition hover:text-black dark:hover:text-white">
                Privacy Policy
              </li>
            </ul>
          </div>

          {/* Social */}
          <div className="space-y-3">
            <h3 className="text-sm font-semibold uppercase tracking-wider">
              Follow Us
            </h3>

            <div className="flex items-center gap-3">
              <button className="rounded-full border border-zinc-300 p-2 transition hover:bg-black hover:text-white dark:border-zinc-700 dark:hover:bg-white dark:hover:text-black">
                <FaFacebookF className="h-4 w-4" />
              </button>

              <button className="rounded-full border border-zinc-300 p-2 transition hover:bg-black hover:text-white dark:border-zinc-700 dark:hover:bg-white dark:hover:text-black">
                <FaInstagram className="h-4 w-4" />
              </button>

              <button className="rounded-full border border-zinc-300 p-2 transition hover:bg-black hover:text-white dark:border-zinc-700 dark:hover:bg-white dark:hover:text-black">
                <FaTwitter className="h-4 w-4" />
              </button>

              <button className="rounded-full border border-zinc-300 p-2 transition hover:bg-black hover:text-white dark:border-zinc-700 dark:hover:bg-white dark:hover:text-black">
                <FaGithub className="h-4 w-4" />
              </button>
            </div>
          </div>
        </div>
      </div>

      {/* Bottom */}
      <div className="border-t border-zinc-200 px-6 py-4 text-center text-sm text-zinc-500 dark:border-zinc-800 dark:text-zinc-400">
        © 2026 ShopSphere. All rights reserved.
      </div>
    </footer>
  );
}
